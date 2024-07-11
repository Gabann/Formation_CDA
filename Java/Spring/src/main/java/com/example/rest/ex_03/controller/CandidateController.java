package com.example.rest.ex_03.controller;

import com.example.rest.ex_03.entity.Candidate;
import com.example.rest.ex_03.service.CandidateService;
import com.example.rest.generic_crud.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidates")
public class CandidateController extends CrudController<Candidate, Long>
{
	protected CandidateController(CandidateService service)
	{
		super(service);
	}
}
