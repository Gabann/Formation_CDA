package com.example.rest.ex_01.controller;


import com.example.generic_crud.CrudController;
import com.example.rest.ex_01.entity.Todo;
import com.example.rest.ex_01.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("restTodoController")
@RequestMapping("/todo")
public class TodoController extends CrudController<Todo, Long>
{
	private final TodoService service;

	protected TodoController(TodoService service)
	{
		super(service);
		this.service = service;
	}

	@GetMapping("/isDone/{isDoneBool}")
	public ResponseEntity<List<Todo>> getByIsDone(@PathVariable Boolean isDoneBool)
	{
		return new ResponseEntity<>(service.getByIsDone(isDoneBool), HttpStatus.OK);
	}

	@PatchMapping("setIsDone/{id}/{isDone}")
	public ResponseEntity<Void> setStatusById(@PathVariable Long id, @PathVariable Boolean isDone)
	{
		Todo todo = service.getById(id).orElse(null);

		if (todo != null)
		{
			todo.setIsDone(isDone);
			service.update(id, todo);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
