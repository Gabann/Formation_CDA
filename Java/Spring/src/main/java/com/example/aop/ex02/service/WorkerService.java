package com.example.aop.ex02.service;

import com.example.aop.ex02.entity.Worker;
import com.example.aop.ex02.repository.WorkerRepository;
import com.example.generic_crud.CrudServiceImpl;

public class WorkerService extends CrudServiceImpl<Worker, Long>
{
	public WorkerService(WorkerRepository repository)
	{
		super(repository);
	}
}
