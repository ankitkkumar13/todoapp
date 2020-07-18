package com.ankit.todo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.ankit.todo.dao.UserDaoImpl;
import com.ankit.todo.error.UserAlreadyExistException;
import com.ankit.todo.model.Authority;
import com.ankit.todo.model.AuthorityType;
import com.ankit.todo.model.User;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDaoImpl userDaoImpl;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	public User findById(String id) {
		
		return userDaoImpl.findById(id);
	}

	@Override
	public void saveUser(User user, Model model ) {
			
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Authority authority=new Authority();
		authority.setType(AuthorityType.ROLE_USER);
		user.getAuthorities().add(authority);
		userDaoImpl.save(user);
	}

}
