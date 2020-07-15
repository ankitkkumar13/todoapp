package com.ankit.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankit.todo.dao.ToDoDaoImpl;
import com.ankit.todo.model.Todo;
@Service
public class TodoService {
@Autowired
ToDoDaoImpl toDoDaoImpl;

public Todo save(Todo todo) {
	return toDoDaoImpl.save(todo);
}

public void update(Todo todo) {
	toDoDaoImpl.update(todo);
}
public void delete(Todo todo) {
	toDoDaoImpl.deleteById(todo);
}
public List<Todo> findAllTod(){
	return toDoDaoImpl.findAll();
}
public List<Todo> findToDoByName(String name) {
	return toDoDaoImpl.findByName(name);
}

public void deleteToDoById(long id) {
toDoDaoImpl.deleteToDoById(id);	
}
public Todo findToDoById(long id) {
	return toDoDaoImpl.findById(id);
}
}
