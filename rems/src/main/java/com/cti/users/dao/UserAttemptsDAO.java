package com.cti.users.dao;

import com.cti.users.model.UserAttempts;

public interface UserAttemptsDAO{

	void updateFailAttempts(String username);

	void resetFailAttempts(String username);
	
	UserAttempts getUserAttempts(String username);

}