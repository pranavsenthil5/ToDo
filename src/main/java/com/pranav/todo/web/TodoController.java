package com.pranav.todo.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.pranav.todo.service.Todo;
import com.pranav.todo.service.Todo.TodoTask;

@Controller
public class TodoController {

	@GetMapping("/greeting")
	public String greeting(
	@RequestParam(name = "name", required = false, defaultValue = "World") String name,
	Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/todos")
	public String todos(Model model)
	{
		model.addAttribute("todos", getTodosFromDatabase());
		return "todos";
	}

	@GetMapping("/todo/{id}")
	public String todo(@PathVariable int id, Model model) 
	{
		Todo todo = getTodoByIdFromDatabase(id);
		model.addAttribute("todo", todo);
		return "todo";
	}

	private List<Todo> getTodosFromDatabase()
	{
		List<Todo> data = new ArrayList<Todo>();

		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "root");
			stmt = conn.createStatement();
			
			String strSelect = "select id, name from todo";
			ResultSet set = stmt.executeQuery(strSelect);
			
			while (set.next())
			{ 
				Todo todo = new Todo(set.getInt("id"), set.getString("name"));
				data.add(todo);
			}

			stmt.close();
			conn.close();

		} catch (Exception E) 
		{
			throw new RuntimeException(E);
		} 
		finally 
		{
			try 
			{
				if (stmt != null)
					stmt.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			try 
			{
				if (conn != null)
					conn.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}

		return data;
	}

	private Todo getTodoByIdFromDatabase(int id) {
		Todo data = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "root");
			
			String strSelect = "SELECT t.id, t.name, t.user_id, tt.id as tt_id,tt.name as tt_name,tt.completed as tt_completed FROM todo t join todo_task tt on t.id=tt.todo_id where t.id=?";
			stmt = conn.prepareStatement(strSelect);
			stmt.setInt(1, id);

			ResultSet set = stmt.executeQuery();
			
			Todo todo = null;
			while (set.next()) 
			{ 
				if (todo == null)
				{
					todo = new Todo(set.getInt("id"), set.getString("name"));
				}
				todo.getTasks().add(new TodoTask(set.getInt("tt_id"), set.getString("tt_name"), set.getBoolean("tt_completed")));
				data = todo;
			}

			stmt.close();
			conn.close();

		} catch (Exception E)
		{
			throw new RuntimeException(E);
		} 
		finally 
		{
			try 
			{
				if (stmt != null)
					{
						stmt.close();
					}
			} 
			catch (Exception e) 
			{
				
			}
			try 
			{
				if (conn != null)
					{
						conn.close();
					}
			} 
			catch (Exception e) 
			{
				
			}
		}

		return data;
	}
}
