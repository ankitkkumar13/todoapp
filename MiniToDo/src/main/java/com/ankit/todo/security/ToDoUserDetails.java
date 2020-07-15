package com.ankit.todo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ankit.todo.model.Authority;
import com.ankit.todo.model.User;
@Service
public class ToDoUserDetails implements UserDetails {
	
	private User user;
	
	public ToDoUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<Authority> authorities = user.getAuthorities();
		Iterator<Authority> iterator = authorities.iterator();
		List<SimpleGrantedAuthority> listAuthority=new ArrayList<>();
		while (iterator.hasNext()) {
			Authority type =iterator.next();
			SimpleGrantedAuthority simpAuth=new SimpleGrantedAuthority(type.getType().name());
			listAuthority.add(simpAuth);
		}
		return listAuthority;
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
