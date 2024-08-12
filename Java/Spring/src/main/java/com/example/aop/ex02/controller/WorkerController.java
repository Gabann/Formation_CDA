package com.example.aop.ex02.controller;

import com.example.aop.ex02.entity.Worker;
import com.example.aop.ex02.service.WorkerService;
import com.example.generic_crud.CrudController;

public class WorkerController extends CrudController<Worker, Long>
{
	protected WorkerController(WorkerService service)
	{
		super(service);
	}
}
