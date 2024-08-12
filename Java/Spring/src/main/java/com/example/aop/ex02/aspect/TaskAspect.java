package com.example.aop.ex02.aspect;

import com.example.aop.ex02.entity.Notification;
import com.example.aop.ex02.entity.Project;
import com.example.aop.ex02.entity.Task;
import com.example.aop.ex02.entity.Worker;
import com.example.aop.ex02.service.NotificationService;
import com.example.aop.ex02.service.TaskService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Set;

@Aspect
@Component
public class TaskAspect
{
	final NotificationService notificationService;

	final TaskService taskService;

	public TaskAspect(NotificationService notificationService, TaskService taskService)
	{
		this.notificationService = notificationService;
		this.taskService = taskService;
	}


	@Pointcut("@annotation(com.example.aop.ex02.annotation.NotifyWorkers)")
	public void notifyWorkersPointcut()
	{
	}

	@After("notifyWorkersPointcut()")
	public void notifyWorkers(JoinPoint joinpoint)
	{
		Long taskId = (Long) joinpoint.getArgs()[0];
		Task.TaskStatus status = (Task.TaskStatus) joinpoint.getArgs()[1];

		Task task = taskService.getById(taskId).orElse(null);
		Project project = task.getProject();
		Set<Worker> workerList = project.getWorkers();

		String message = "Task " + task.getTitle() + " has been updated to " + status;

		System.out.println(message);

		workerList.forEach(worker -> notificationService.create(new Notification(worker, message)));
	}
}
