package com.example.rest.ex_03.back.service;

import com.example.generic_crud.CrudServiceImpl;
import com.example.rest.ex_03.back.entity.Candidate;
import com.example.rest.ex_03.back.repository.CandidateRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidateService extends CrudServiceImpl<Candidate, Long>
{

	public CandidateService(CandidateRepository repository)
	{
		super(repository);
	}
}
