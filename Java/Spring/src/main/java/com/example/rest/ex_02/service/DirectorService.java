package com.example.rest.ex_02.service;

import com.example.generic_crud.CrudServiceImpl;
import com.example.rest.ex_02.entity.Director;
import com.example.rest.ex_02.repository.DirectorRepository;
import org.springframework.stereotype.Service;

@Service
public class DirectorService extends CrudServiceImpl<Director, Long>
{
	public DirectorService(DirectorRepository repository)
	{
		super(repository);
	}
}
