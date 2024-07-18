package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.dto.TodoCreationDto;
import com.example.springsecurityjwt.model.Todo;
import com.example.springsecurityjwt.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
public class TodoController
{
	final TodoService todoService;

	public TodoController(TodoService todoService)
	{
		this.todoService = todoService;
	}

	@PostMapping("/admin/post")
	public ResponseEntity<Todo> createTodo(@RequestBody TodoCreationDto todoCreationDto)
	{
		return ResponseEntity.ok(todoService.saveTodo(todoCreationDto));
	}

	@GetMapping
	public ResponseEntity<List<Todo>> getAllTodos()
	{
		return ResponseEntity.ok(todoService.getAllTodo());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable Long id)
	{
		Optional<Todo> product = todoService.getTodoById(id);
		return product.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/admin/update")
	public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo)
	{
		return ResponseEntity.ok(todoService.updateTodo(todo));
	}

	@DeleteMapping("/admin/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable Long id)
	{
		todoService.deleteTodo(id);
		return ResponseEntity.ok().build();
	}
}
