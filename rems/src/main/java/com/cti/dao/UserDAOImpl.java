/**
 * 
 */
package com.cti.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cti.model.User;

/**
 * @author nathanr_kamal
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveUser(User user) {
		openSession().save(user);

	}

	@Override
	public void updateUser(User user) {
		openSession().update(user);

	}

	@Override
	public void removeUser(String username) {
		User user = (User) openSession().get(User.class, username);

		if (null != user) {
			openSession().delete(user);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserById(String username) {
		Session session = openSession().getSessionFactory().getCurrentSession();

		List<User> list = session
				.createQuery("from User b where b.username = :username")
				.setParameter("username", username).list();
		return list.size() > 0 ? (User) list.get(0) : null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		return openSession().getSessionFactory().getCurrentSession()
				.createQuery("from User").list();
	}

}
