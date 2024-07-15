package com.example.security.ex_01.service;

import com.example.generic_crud.CrudServiceImpl;
import com.example.security.ex_01.entity.TestEntity;
import com.example.security.ex_01.repository.TestEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class TestEntityService extends CrudServiceImpl<TestEntity, Long>
{
	public TestEntityService(TestEntityRepository repository)
	{
		super(repository);
	}
}
