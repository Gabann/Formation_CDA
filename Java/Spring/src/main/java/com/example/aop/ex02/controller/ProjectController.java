package com.example.aop.ex02.controller;

import com.example.aop.ex02.entity.Project;
import com.example.aop.ex02.service.ProjectService;
import com.example.generic_crud.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController extends CrudController<Project, Long>
{
	protected ProjectController(ProjectService service)
	{
		super(service);
	}
}
