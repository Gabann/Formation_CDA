package com.example.security.ex_01.controller;

import com.example.generic_crud.CrudController;
import com.example.security.ex_01.entity.TestEntity;
import com.example.security.ex_01.service.TestEntityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class TestEntityController extends CrudController<TestEntity, Long>
{
	protected TestEntityController(TestEntityService service)
	{
		super(service);
	}
}
