package com.example.aop.ex02.service;

import com.example.aop.ex02.entity.Notification;
import com.example.aop.ex02.repository.NotificationRepository;
import com.example.generic_crud.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class NotificationService extends CrudServiceImpl<Notification, Long>
{
	public NotificationService(NotificationRepository repository)
	{
		super(repository);
	}
}
