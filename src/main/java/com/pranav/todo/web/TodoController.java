package com.pranav.todo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pranav.todo.service.Todo;
import com.pranav.todo.service.Todo.TodoTask;

@Controller //This annotation tells the compiler that this is a Controller
public class TodoController //This class controls the webpage
{
	@GetMapping("/greeting") //Get Mapping Listens to the url;In this case listens to '/greeting'
	public String greeting(
	@RequestParam(name = "name", required = false, defaultValue = "World") String name,//RequestParam gets the parameteters from the url
	Model model) //model has all the parameters
	{
		model.addAttribute("name", name);
		return "greeting"; //calls the 'greeting.html' page
	}
	
	@GetMapping("/todos")
	public String todos(Model model) {
		model.addAttribute("todos", getDummyTodos());
		return "todos";
	}
	
	public List<Todo> getDummyTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/todo/{id}") //Get Mapping listens to '/todo/{id}'
	public String todo()
	{
		return "todo"; //calls the 'todo.html' page
	}
	
}
