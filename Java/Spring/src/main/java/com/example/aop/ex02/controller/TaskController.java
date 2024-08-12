package com.example.aop.ex02.controller;

import com.example.aop.ex02.annotation.NotifyWorkers;
import com.example.aop.ex02.entity.Task;
import com.example.aop.ex02.service.TaskService;
import com.example.generic_crud.CrudController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController extends CrudController<Task, Long>
{
	private final TaskService service;

	protected TaskController(TaskService service)
	{
		super(service);
		this.service = service;
	}

	@NotifyWorkers
	@PostMapping("/updateStatus/{taskId}")
	void updateTaskStatusById(@PathVariable Long taskId, @RequestParam Task.TaskStatus status)
	{
		Task task = service.getById(taskId).orElse(null);
		service.SetStatus(task, status);
	}
}
