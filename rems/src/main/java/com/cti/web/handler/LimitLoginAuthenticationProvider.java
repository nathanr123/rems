package com.cti.web.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.cti.users.dao.UserAttemptsDao;
import com.cti.users.model.UserAttempts;

@Component("authenticationProvider")
public class LimitLoginAuthenticationProvider extends DaoAuthenticationProvider {

	@Autowired
	UserAttemptsDao userAttemptsDao;
	
	@Autowired
	@Qualifier("userAttemptsService")
	@Override
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		super.setUserDetailsService(userDetailsService);
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		try {

			Authentication auth = super.authenticate(authentication);
			
			//if reach here, means login success, else exception will be thrown
			//reset the user_attempts
			userAttemptsDao.resetFailAttempts(authentication.getName());
			
			return auth;
			
		} catch (BadCredentialsException e) {	
			
			//invalid login, update to user_attempts
			userAttemptsDao.updateFailAttempts(authentication.getName());
			throw e;
			
		} catch (LockedException e){
			
			//this user is locked!
			String error = "";
			UserAttempts userAttempts = userAttemptsDao.getUserAttempts(authentication.getName());
			if(userAttempts!=null){				
				error = "User account is locked! <br><br>Username : " + authentication.getName() + "<br>Last Attempts : " + userAttempts.getModifiedtime();
			}else{
				error = e.getMessage();
			}
			
			throw new LockedException(error);
		}

	}

}