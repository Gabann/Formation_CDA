package com.example.rest.ex_03.controller;

import com.example.rest.ex_03.entity.Absence;
import com.example.rest.ex_03.service.AbsenceService;
import com.example.rest.generic_crud.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/absences")
public class AbsenceController extends CrudController<Absence, Long>
{
	protected AbsenceController(AbsenceService service)
	{
		super(service);
	}
}
