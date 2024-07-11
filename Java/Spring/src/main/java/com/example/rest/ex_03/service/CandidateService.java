package com.example.rest.ex_03.service;

import com.example.rest.ex_03.entity.Candidate;
import com.example.rest.ex_03.repository.CandidateRepository;
import com.example.rest.generic_crud.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CandidateService extends CrudServiceImpl<Candidate, Long>
{

	public CandidateService(CandidateRepository repository)
	{
		super(repository);
	}
}
