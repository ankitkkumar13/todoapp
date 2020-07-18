package com.ankit.todo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ankit.todo.model.User;
import com.ankit.todo.model.UserModel;
import com.ankit.todo.services.UserServiceImpl;

@Controller
public class UserController {
	
	 @GetMapping("/valid")
	    public String checkforvalid(Model model){
	        model.addAttribute("user",new UserModel());
	        return "validform";
	    }
	 
	    @PostMapping(value = "/testValid")
	    public String testvalid(@Valid @ModelAttribute(name = "user") UserModel um,BindingResult br){
	        if(br.hasErrors()){
	            return "validform";
	        }else{
	            return "final";
	        }
	    }
	
	@Autowired
	UserServiceImpl userServiceImpl;
	@RequestMapping(value = "/signup",method = RequestMethod.GET)
public String showUserSignupForm(Model model) {
	model.addAttribute("user",new User());
	return "signup";
}
	@RequestMapping(value="/signup",method = RequestMethod.POST)
	public String registerUser( @ModelAttribute(name = "user") @Valid User user,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())
			return "signup";
		
		User findById = userServiceImpl.findById(user.getEmail());
		if(findById!=null)
		{
			bindingResult.rejectValue("email", "error.user", "An account already exists for this email.");
			System.out.println(bindingResult.hasErrors());
			
		return "signup";
		
		}
		userServiceImpl.saveUser(user,null);
		if(bindingResult.hasErrors())
			return "signup";
		return "redirect:/login";
	}
	
}
