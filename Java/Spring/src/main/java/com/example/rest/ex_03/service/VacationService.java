package com.example.rest.ex_03.service;

import com.example.rest.ex_03.entity.Vacation;
import com.example.rest.ex_03.repository.VacationRepository;
import com.example.rest.generic_crud.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class VacationService extends CrudServiceImpl<Vacation, Long>
{
	public VacationService(VacationRepository repository)
	{
		super(repository);
	}
}
