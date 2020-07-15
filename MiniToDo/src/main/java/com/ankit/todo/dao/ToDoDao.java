package com.ankit.todo.dao;

import java.util.List;

import com.ankit.todo.model.Todo;


public interface ToDoDao {
	Todo save(Todo todo);
	Todo findById(long id);
	List<Todo> findByName(String name);
	List<Todo> findAll();
	boolean isExists(long id);
	void update(Todo todo);
	void deleteById(Todo id);
	Todo findByToDoById(long id);
	void deleteToDoById(long id);

}
