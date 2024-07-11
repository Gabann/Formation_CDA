package com.example.rest.ex_03.service;

import com.example.rest.ex_03.entity.Absence;
import com.example.rest.ex_03.repository.AbsenceRepository;
import com.example.rest.generic_crud.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AbsenceService extends CrudServiceImpl<Absence, Long>
{

	public AbsenceService(AbsenceRepository repository)
	{
		super(repository);
	}
}
