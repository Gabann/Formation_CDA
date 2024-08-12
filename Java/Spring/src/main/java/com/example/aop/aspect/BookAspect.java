package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect
{
	@Pointcut("@annotation(com.example.aop.annotation.AspectAnnotation)")
	public void annotationPointcut()
	{
	}
//
//	@Pointcut("execution (* com.example.aop.controller.BookController+.*(..))")
//	public void bookControllerMethods()
//	{
//	}

	@Before("annotationPointcut()")
	public void beforeReturningEveryMethod()
	{
		System.out.println("Before method");
	}

	@After("annotationPointcut()")
	public void afterReturningEveryMethod()
	{
		System.out.println("After method");
	}

	@Around("annotationPointcut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint)
	{
		double msBeforeCall = System.currentTimeMillis();

		try
		{
			Object[] args = proceedingJoinPoint.getArgs();
			Object result = proceedingJoinPoint.proceed(args);

			double executionTime = System.currentTimeMillis() - msBeforeCall;
			System.out.printf("Method took %s ms to execute %n", executionTime);
			return result;
		}
		catch (Exception ex)
		{
			System.out.println("Catch exception with around cut");
		}
		catch (Throwable e)
		{
			throw new RuntimeException(e);
		} finally
		{
			return null;
		}
	}
}
