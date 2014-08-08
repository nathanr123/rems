/**
 * 
 */
package com.cti.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cti.common.REMS;
import com.cti.users.dao.UserDAO;
import com.cti.users.model.User;
import com.cti.users.model.UserDetail;

/**
 * @author nathanr_kamal
 *
 */
@Service("UsersService")
public class UserService implements UserDAO {

	@Autowired
	UserDAO userDAO;

	@Override
	public User getUser(String username) {

		return this.userDAO.getUser(username);
	}

	@Override
	public List<User> getAllUsers() {

		return this.userDAO.getAllUsers();
	}

	@Override
	public UserDetail getUserDetail(String username) {

		return this.getUserDetail(username);
	}

	@Override
	public void save(REMS remsObj) {
		this.userDAO.save(remsObj);

	}

	@Override
	public void update(REMS remsObj) {
		this.userDAO.update(remsObj);

	}

	@Override
	public void delete(REMS remsObj) {
		this.userDAO.delete(remsObj);

	}
}
