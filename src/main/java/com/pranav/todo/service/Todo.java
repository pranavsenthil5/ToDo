package com.pranav.todo.service;

import java.util.ArrayList;
import java.util.List;

public class Todo {

	public Integer id; //Id of the todo category
	private String name; //Name of the todo category
	private List<TodoTask> tasks = new ArrayList<Todo.TodoTask>(); //list of tasks

	public Todo() {

	}

	public Todo(int id, String name) { //constructot
		this.id = id;
		this.name = name;
	}
	//below 6 methods are getters and setters
	public List<TodoTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<TodoTask> tasks) {
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

	public static class TodoTask {//nested class :to use the object directly in the outer class 
		private Integer id;
		private String name;
		private boolean completed = false;

		public TodoTask() 
		{
			
		}

		public TodoTask(int id, String name, boolean completed)//contructor
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
