package com.cti.users.dao;

import com.cti.users.model.UserAttempts;

public interface UserAttemptsDao extends DAO{

	void updateFailAttempts(String username);

	void resetFailAttempts(String username);
	
	UserAttempts getUserAttempts(String username);

}