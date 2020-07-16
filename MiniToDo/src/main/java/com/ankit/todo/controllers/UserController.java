package com.ankit.todo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ankit.todo.model.User;
import com.ankit.todo.services.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;
	@RequestMapping(value = "/signup",method = RequestMethod.GET)
public String showUserSignupForm(Model model) {
	model.addAttribute("user",new User());
	return "signup";
}
	@RequestMapping(value="/signup",method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute(name = "user") User user,BindingResult bindingResult,Model model) {
		
		if(bindingResult.hasErrors())
			return "signup";
		model.addAttribute("user",new User());
		userServiceImpl.saveUser(user,model);
		return "redirect:/login";
	}
	
}
