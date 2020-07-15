package com.ankit.todo.services;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ankit.todo.dao.UserDaoImpl;
import com.ankit.todo.model.User;
import com.ankit.todo.security.ToDoUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDaoImpl userDaoImpl;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userDaoImpl.findById(username);
		if(user==null) {
			throw new UsernameNotFoundException("Can't find user by this eamil");
		}
		return new ToDoUserDetails(user);
	}

}
