package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.dto.TodoCreationDto;
import com.example.springsecurityjwt.model.Todo;
import com.example.springsecurityjwt.repository.TodoRepository;
import com.example.springsecurityjwt.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService
{
	final UserRepository userRepository;
	final TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository, UserRepository userRepository)
	{
		this.todoRepository = todoRepository;
		this.userRepository = userRepository;
	}

	public Optional<Todo> getTodoById(Long id)
	{
		return todoRepository.findById(id);
	}

	public Todo saveTodo(TodoCreationDto todoCreationDto)
	{
		System.out.println(todoCreationDto);
		Todo todo = todoCreationDto.getTodo();
		todo.setUser(
				userRepository.findById(todoCreationDto.getUserId())
						.orElseThrow(() -> new RuntimeException("User not found")));
		return todoRepository.save(todo);
	}

	public List<Todo> getAllTodo()
	{
		return todoRepository.findAll();
	}

	public Todo updateTodo(Todo todo)
	{
		return todoRepository.save(todo);
	}

	public void deleteTodo(Long id)
	{
		todoRepository.deleteById(id);
	}
}
