package com.ankit.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ankit.todo.dao.UserDaoImpl;
import com.ankit.todo.model.Authority;
import com.ankit.todo.model.AuthorityType;
import com.ankit.todo.model.User;
@Component
public class BootStrapData implements CommandLineRunner {
	@Autowired
	UserDaoImpl userDaoImpl;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Authority authority=new Authority();
		authority.setType(AuthorityType.ROLE_ADMIN);
		
		User user=new User();
		user.setEmail("ankit@diro.io");
		user.setPassword("$2a$10$PENWcp9NvgWY.tt5ZnU4pevZkebWbcKVefDJ/2wdra7EElUHODlyS");
		user.getAuthorities().add(authority);
//		authority.getUsers().add(user);
		userDaoImpl.save(user);
		
	}

}
