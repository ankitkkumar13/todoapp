package com.ankit.todo.services;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.ankit.todo.model.User;

public interface UserService {
	User findById(String id);
	void saveUser(User user,Model model);
}
