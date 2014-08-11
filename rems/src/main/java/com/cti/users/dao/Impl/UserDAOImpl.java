/**
 * 
 */
package com.cti.users.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.cti.users.dao.UserDAO;
import com.cti.users.model.User;
import com.cti.util.HibernateDAOEx;

/**
 * @author nathanr_kamal
 *
 */
@Repository
public class UserDAOImpl extends HibernateDAOEx implements UserDAO {

	@Override
	public void saveUser(User user) {
		getHibernateTemplate().save(user);

	}

	@Override
	public void updateUser(User user) {
		getHibernateTemplate().update(user);

	}

	@Override
	public void removeUser(String username) {
		User user = getHibernateTemplate().load(User.class, username);

		if (null != user) {
			getHibernateTemplate().delete(user);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserById(String username) {
		Session session = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		List<User> list = session
				.createQuery("from User b where b.username = :username")
				.setParameter("username", username).list();
		return list.size() > 0 ? (User) list.get(0) : null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		return getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery("from User").list();
	}

}
