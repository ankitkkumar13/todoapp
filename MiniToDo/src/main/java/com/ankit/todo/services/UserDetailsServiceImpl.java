package com.ankit.todo.services;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ankit.todo.dao.UserDaoImpl;
import com.ankit.todo.model.User;
import com.ankit.todo.security.ToDoUserDetails;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDaoImpl userDaoImpl;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("user name "+username);
		User user=userDaoImpl.findById(username);
//		System.out.println(user.getEmail());
		if(user==null) {
			throw new UsernameNotFoundException("Can't find user by this eamil");
		}
		return new ToDoUserDetails(user);
	}

}
