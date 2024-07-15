package com.example.rest.ex_03.back.controller;

import com.example.generic_crud.CrudController;
import com.example.rest.ex_03.back.entity.Absence;
import com.example.rest.ex_03.back.service.AbsenceService;
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
