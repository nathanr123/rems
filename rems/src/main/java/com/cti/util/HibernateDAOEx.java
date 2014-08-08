package com.cti.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class HibernateDAOEx extends HibernateDaoSupport {

	@Autowired
	public void loadSession(SessionFactory sessionFactory) {
		
		setSessionFactory(sessionFactory);
	}
}
