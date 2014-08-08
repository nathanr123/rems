/**
 * 
 */
package com.cti.users.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cti.common.REMS;
import com.cti.users.dao.UserDAO;
import com.cti.users.model.User;
import com.cti.users.model.UserDetail;
import com.cti.util.HibernateDAOEx;

/**
 * @author nathanr_kamal
 *
 */
@Repository("userDAO")
public class UserDAOImpl extends HibernateDAOEx implements UserDAO {

	@Override
	public User getUser(String username) {

		List list = getHibernateTemplate().find("from User where username=?",
				username);
		return (User) list.get(0);
	}

	@Override
	public List<User> getAllUsers() {
		List list = getHibernateTemplate().find("from User");
		return list;
	}

	@Override
	public UserDetail getUserDetail(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(REMS remsObj) {
		getHibernateTemplate().save((User) remsObj);

	}

	@Override
	public void update(REMS remsObj) {
		getHibernateTemplate().update((User) remsObj);

	}

	@Override
	public void delete(REMS remsObj) {
		getHibernateTemplate().delete((User) remsObj);

	}

}
