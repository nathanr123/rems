package com.cti.users.dao;

import java.util.List;

import com.cti.users.model.User;
import com.cti.users.model.UserDetail;

public interface UserDAO extends DAO {
	
	User getUser(String username);

	List<User> getAllUsers();
	
	UserDetail getUserDetail(String username);
}
