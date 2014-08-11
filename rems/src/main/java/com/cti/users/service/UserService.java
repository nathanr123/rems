/**
 * 
 */
package com.cti.users.service;

import java.util.List;

import com.cti.users.model.User;

/**
 * @author nathanr_kamal
 *
 */

public interface UserService {

	public void saveUser(User user);

	public void updateUser(User user);

	public void removeUser(String username);

	public User getUserById(String username);

	public List<User> listUsers();

}
