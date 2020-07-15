package com.ankit.todo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankit.todo.model.Todo;

@Component
public class ToDoDaoImpl implements ToDoDao {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public Todo save(Todo todo) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(todo);
		transaction.commit();
		return todo;
	}

	@Override
	public Todo findById(long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Todo todo=(Todo) session.byId(Todo.class).load(id);
		session.close();
		return todo;
		
	}

	@Override
	public List<Todo> findByName(String name) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Todo.class);
		criteria.add(Restrictions.eq("userName", name));
		return  criteria.list();
	}

	@Override
	public List<Todo> findAll() {
		Session session=sessionFactory.openSession();
		List<Todo> list=session.createCriteria(Todo.class).list();
		session.close();
		return list;
	}

	@Override
	public boolean isExists(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Todo todo) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(todo);
		transaction.commit();
		session.close();
	}

	@Override
	public void deleteById(Todo id) {
		Session session=sessionFactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		session.delete(id);
		beginTransaction.commit();
		session.close();
	}
@Override
	public void deleteToDoById(long id) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria cr=session.createCriteria(Todo.class);
		cr.add(Restrictions.idEq(id));
		session.delete(cr.list().get(0));
		transaction.commit();
		session.close();
	}
	@Override
	public Todo findByToDoById(long id) {
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Todo.class);
		cr.add(Restrictions.idEq(id));
		return (Todo) cr.list().get(0);
	}

}
