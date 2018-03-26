package com.pranav.todo.service;

import java.util.ArrayList;
import java.util.List;

public class TodoDTO {
	//test
	public Integer id; //Id of the todo category
	private String name; //Name of the todo category
	private List<TodoTaskDTO> tasks = new ArrayList<TodoDTO.TodoTaskDTO>(); //list of tasks

	public TodoDTO() {

	}

	public TodoDTO(int id, String name) { //constructot
		this.id = id;
		this.name = name;
	}
	//below 6 methods are getters and setters
	public List<TodoTaskDTO> getTasks() {
		return tasks;
	}

	public void setTasks(List<TodoTaskDTO> tasks) {
		this.tasks = tasks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static class TodoTaskDTO {//nested class :to use the object directly in the outer class 
		private Integer id;
		private String name;
		private boolean completed = false;

		public TodoTaskDTO() 
		{
			
		}

		public TodoTaskDTO(int id, String name, boolean completed)//contructor
		{
			this.id = id; 
			this.name = name;
			this.completed = completed;
		}
		//below 6 methods are getters and setters
		public Integer getId() 
		{
			return id;
		}

		public void setId(Integer id) 
		{
			this.id = id;
		}

		public String getName() 
		{
			return name;
		}

		public void setName(String name) 
		{
			this.name = name;
		}

		public boolean isCompleted()
		{
			return completed;
		}

		public void setCompleted(boolean completed) 
		{
			this.completed = completed;
		}

	}
}
