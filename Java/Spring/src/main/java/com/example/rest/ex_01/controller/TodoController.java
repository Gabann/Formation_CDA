package com.example.rest.ex_01.controller;


import com.example.rest.ex_01.entity.Todo;
import com.example.rest.ex_01.service.TodoService;
import com.example.rest.generic_crud.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("restTodoController")
@RequestMapping("/todo")
public class TodoController extends CrudController<Todo, Long>
{
	protected TodoController(TodoService service)
	{
		super(service);
	}
}
