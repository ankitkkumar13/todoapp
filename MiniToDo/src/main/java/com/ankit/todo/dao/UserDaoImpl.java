package com.ankit.todo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankit.todo.model.User;
@Component
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public User findById(String id) {
		System.out.println("User id "+id);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		User user = session.find(User.class, id);
		return user;
	}
	
	public User save(User user) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		return user;
	}

}
