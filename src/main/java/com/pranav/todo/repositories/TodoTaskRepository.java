package com.pranav.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pranav.todo.entities.TodoTask;

public interface TodoTaskRepository extends JpaRepository<TodoTask,Integer>, JpaSpecificationExecutor<TodoTask>
{

}
