package com.example.aop.ex02.service;

import com.example.aop.ex02.entity.Task;
import com.example.aop.ex02.repository.TaskRepository;
import com.example.generic_crud.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TaskService extends CrudServiceImpl<Task, Long>
{
	TaskRepository repository;

	public TaskService(TaskRepository repository)
	{
		super(repository);
		this.repository = repository;
	}

	public void SetStatus(Task task, Task.TaskStatus status)
	{
		task.setStatus(status);
	}
}
