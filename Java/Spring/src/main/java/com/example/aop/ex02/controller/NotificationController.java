package com.example.aop.ex02.controller;

import com.example.aop.ex02.entity.Notification;
import com.example.aop.ex02.service.NotificationService;
import com.example.generic_crud.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController extends CrudController<Notification, Long>
{
	protected NotificationController(NotificationService service)
	{
		super(service);
	}
}
