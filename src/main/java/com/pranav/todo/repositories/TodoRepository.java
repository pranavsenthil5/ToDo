package com.pranav.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pranav.todo.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo,Integer>, JpaSpecificationExecutor<Todo>
{

}
