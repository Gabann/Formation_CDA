package com.example.rest.ex_03.back.controller;

import com.example.generic_crud.CrudController;
import com.example.rest.ex_03.back.entity.Candidate;
import com.example.rest.ex_03.back.service.CandidateService;
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
