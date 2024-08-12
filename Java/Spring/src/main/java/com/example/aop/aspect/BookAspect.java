package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect
{
	@Pointcut("execution (* com.example.aop.controller.BookController+.*(..)) ||" +
			" execution(* com.example.generic_crud.CrudController.*(..))")
	public void bookControllerMethods()
	{
	}

	@Before("bookControllerMethods()")
	public void beforeReturningEveryMethod()
	{
		System.out.println("Before method");
	}

	@After("bookControllerMethods()")
	public void afterReturningEveryMethod()
	{
		System.out.println("After method");
	}

	@Around("bookControllerMethods()")
	public void around(ProceedingJoinPoint proceedingJoinPoint)
	{
		double msBeforeCall = System.currentTimeMillis();

		Object[] args = proceedingJoinPoint.getArgs();
		try
		{
			proceedingJoinPoint.proceed(args);
		}
		catch (Throwable e)
		{
			throw new RuntimeException(e);
		}

		double executionTime = System.currentTimeMillis() - msBeforeCall;
		System.out.printf("Method took %s ms to execute %n", executionTime);
	}
}
