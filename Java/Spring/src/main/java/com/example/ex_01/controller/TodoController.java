package com.example.ex_01.controller;

import com.example.ex_01.entity.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TodoController
{
	@RequestMapping("/")
	public String returnIndex()
	{
		return "index";
	}

	@RequestMapping("/todo/all")
	@ResponseBody
	public List<Todo> returnAllTodo()
	{
		return List.of(new Todo("test", "test", false), new Todo("test2", "test2", true));
	}

	@RequestMapping("/todo/one")
	public String returnOneTodo(Model model)
	{
		model.addAttribute("task", new Todo("test", "test", false));
		return "todoList";
	}
}
