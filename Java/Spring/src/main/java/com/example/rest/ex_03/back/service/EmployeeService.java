package com.example.rest.ex_03.back.service;

import com.example.generic_crud.CrudServiceImpl;
import com.example.rest.ex_03.back.entity.Employee;
import com.example.rest.ex_03.back.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends CrudServiceImpl<Employee, Long>
{
	public EmployeeService(EmployeeRepository repository)
	{
		super(repository);
	}
}
