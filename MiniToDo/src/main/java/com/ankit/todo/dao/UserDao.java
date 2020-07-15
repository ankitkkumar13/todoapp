package com.ankit.todo.dao;

import com.ankit.todo.model.User;

public interface UserDao {
User findById(String id);
}
