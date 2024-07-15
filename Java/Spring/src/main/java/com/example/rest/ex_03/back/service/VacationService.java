package com.example.rest.ex_03.back.service;

import com.example.generic_crud.CrudServiceImpl;
import com.example.rest.ex_03.back.entity.Vacation;
import com.example.rest.ex_03.back.repository.VacationRepository;
import org.springframework.stereotype.Service;

@Service
public class VacationService extends CrudServiceImpl<Vacation, Long>
{
	public VacationService(VacationRepository repository)
	{
		super(repository);
	}
}
