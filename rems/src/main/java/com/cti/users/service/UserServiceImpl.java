package com.cti.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cti.users.dao.UserDAO;
import com.cti.users.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Transactional
	public void saveUser(User user) {
		userDAO.saveUser(user);

	}

	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);

	}

	@Transactional
	public void removeUser(String username) {
		userDAO.removeUser(username);

	}

	@Transactional
	public User getUserById(String username) {

		return userDAO.getUserById(username);
	}

	@Transactional
	public List<User> listUsers() {

		return userDAO.listUsers();
	}

}
