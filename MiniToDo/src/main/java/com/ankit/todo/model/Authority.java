package com.ankit.todo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Authority {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Enumerated(EnumType.STRING)
	private AuthorityType type;
	
	@ManyToMany(mappedBy = "authorities")
	private Set<User> users=new HashSet<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AuthorityType getType() {
		return type;
	}
	public void setType(AuthorityType type) {
		this.type = type;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Authority(int id, AuthorityType type, Set<User> users) {
		super();
		this.id = id;
		this.type = type;
		this.users = users;
	}
	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
