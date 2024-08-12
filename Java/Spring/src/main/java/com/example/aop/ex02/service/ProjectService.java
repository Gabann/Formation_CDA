package com.example.aop.ex02.service;

import com.example.aop.ex02.entity.Project;
import com.example.aop.ex02.repository.ProjectRepository;
import com.example.generic_crud.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProjectService extends CrudServiceImpl<Project, Long>
{
	private final ProjectRepository repository;

	public ProjectService(ProjectRepository repository)
	{
		super(repository);
		this.repository = repository;
	}

//	public getWorkers(Long projectId)
//	{
//		return repository.getOne(projectId).getWorkers();
//	}
}
