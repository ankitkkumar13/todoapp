package com.ankit.todo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@NotBlank(message = "Email id is required")
	private String email;
	@NotBlank(message = "password is required")
	private String password;
	@NotBlank(message = "firstname is required")
	private String firstName;
	private String lastName;
	@OneToMany(mappedBy = "user")
	private Set<Todo> todos=new HashSet<>();
	
	public Set<Todo> getTodos() {
		return todos;
	}

	public void setTodos(Set<Todo> todos) {
		this.todos = todos;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "user_authority",
	joinColumns = {@JoinColumn(name="user_id")},
	inverseJoinColumns = {@JoinColumn(name="authority_id")})
	Set<Authority> authorities=new HashSet<>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String email, String password, Set<Authority> authorities) {
		super();
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

}
