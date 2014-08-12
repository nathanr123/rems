/**
 * 
 */
package com.cti.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cti.dao.GroupDAO;
import com.cti.dao.UserDAO;
import com.cti.dao.UserGroupListDAO;
import com.cti.dao.UserRoleDAO;
import com.cti.model.UserRole;
import com.cti.model.UsersGroupList;

/**
 * @author dharshini
 *
 */
@Service
@Transactional(readOnly=true)
public class REMSUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private GroupDAO groupDAO;
	@Autowired
	private UserGroupListDAO userGroupListDAO;
	@Autowired
	private UserRoleDAO userRoleDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		com.cti.model.User domainUser = userDAO.getUserById(username);

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(domainUser.getUsername(), domainUser.getPassword(),
				enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, getAuthorities(username));
	}

	public Collection<? extends GrantedAuthority> getAuthorities(String username) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(username));
		return authList;
	}

	public List<String> getRoles(String username) {

		List<String> roles = new ArrayList<String>();

		List<UsersGroupList> grpList = userGroupListDAO
				.getUserGroupListByUserId(username);

		for (Iterator<UsersGroupList> iterator = grpList.iterator(); iterator.hasNext();) {

			UsersGroupList usersGroupList =  iterator.next();

			UserRole userRole = userRoleDAO.getRoleById(groupDAO.getGroupById(
					usersGroupList.getGroupid()).getRoleid());

			if (!roles.contains(userRole.getRoletype())) {
				roles.add(userRole.getRoletype());
			}
		}

		return roles;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
