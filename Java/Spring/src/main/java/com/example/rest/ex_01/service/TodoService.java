package com.example.rest.ex_01.service;

import com.example.rest.ex_01.entity.Todo;
import com.example.rest.ex_01.repository.TodoRepository;
import com.example.rest.generic_crud.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TodoService extends CrudServiceImpl<Todo, Long>
{
	public TodoService(TodoRepository repository)
	{
		super(repository);
	}
}
