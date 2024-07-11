package com.example.rest.ex_03.back.controller;

import com.example.rest.ex_03.back.entity.Vacation;
import com.example.rest.ex_03.back.service.VacationService;
import com.example.rest.generic_crud.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vacations")
public class VacationController extends CrudController<Vacation, Long>
{
	protected VacationController(VacationService service)
	{
		super(service);
	}
}
