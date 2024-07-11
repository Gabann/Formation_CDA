package com.example.rest.ex_03.back.controller;

import com.example.rest.ex_03.back.entity.Employee;
import com.example.rest.ex_03.back.service.EmployeeService;
import com.example.rest.generic_crud.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController extends CrudController<Employee, Long>
{
	protected EmployeeController(EmployeeService service)
	{
		super(service);
	}
}
