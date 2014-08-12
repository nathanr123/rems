/**
 * 
 */
package com.cti.users.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cti.users.dao.UserDAO;
import com.cti.users.model.User;

/**
 * @author nathanr_kamal
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	protected HibernateTemplate template = null;

	/**
	 * Sets Hibernate session factory.
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void saveUser(User user) {
		template.save(user);

	}

	@Override
	public void updateUser(User user) {
		template.update(user);

	}

	@Override
	public void removeUser(String username) {
		User user = template.get(User.class, username);

		if (null != user) {
			template.delete(user);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserById(String username) {
		Session session = template.getSessionFactory().getCurrentSession();

		List<User> list = session
				.createQuery("from User b where b.username = :username")
				.setParameter("username", username).list();
		return list.size() > 0 ? (User) list.get(0) : null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		return template.getSessionFactory().getCurrentSession()
				.createQuery("from User").list();
	}

}
