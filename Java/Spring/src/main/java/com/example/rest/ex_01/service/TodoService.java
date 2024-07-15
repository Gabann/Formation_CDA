package com.example.rest.ex_01.service;

import com.example.generic_crud.CrudServiceImpl;
import com.example.rest.ex_01.entity.Todo;
import com.example.rest.ex_01.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService extends CrudServiceImpl<Todo, Long>
{
	private final TodoRepository repository;

	public TodoService(TodoRepository repository)
	{
		super(repository);
		this.repository = repository;
	}

	public List<Todo> getByIsDone(Boolean isDoneBool)
	{
		return repository.findByIsDone(isDoneBool);
	}
}
