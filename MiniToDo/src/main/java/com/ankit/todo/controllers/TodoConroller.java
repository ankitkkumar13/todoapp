package com.ankit.todo.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ankit.todo.TodoService;
import com.ankit.todo.model.Todo;

@Controller
public class TodoConroller {
	@Autowired
	TodoService toDoService;
	@InitBinder
	public void binder(WebDataBinder binder) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	@RequestMapping("/list-todos")
	public String getToDos(Model model) {
		String name=getLogedInUserName(model);
		model.addAttribute("todos",toDoService.findToDoByName(name));
		return "/list-todos";
	}
	private String getLogedInUserName(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			model.addAttribute("name", ((UserDetails)principal).getUsername());
		}
		return (String) model.getAttribute("name");
	}
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String showAddTodoPage(Model model) {
		model.addAttribute("todo",new Todo());
		return "todo";
		
	}
	@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
	public String deleteToDo(@RequestParam("id") long id) {
		toDoService.deleteToDoById(id);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam("id") long id,Model model) {
		model.addAttribute("todo",toDoService.findToDoById(id));
		return "todo";
	}
	@RequestMapping(value="/update-todo",method=RequestMethod.POST)
	public String updateToDo(Model model,@Validated Todo todo,BindingResult br) {
		if(br.hasErrors())
			return "todo";
		todo.setUserName(getLogedInUserName(model));
		toDoService.update(todo);
		return "redirect:/list-todos";
		
	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String addToDo(Model model,@Validated Todo todo,BindingResult br) {
		if(br.hasErrors())
			return "todo";
		todo.setUserName(getLogedInUserName(model));
		toDoService.save(todo);
		return "redirect:/list-todos";
		
	}
}
