package com.example.aop.ex01.controller;

import com.example.aop.ex01.annotation.AspectAnnotation;
import com.example.aop.ex01.entity.Book;
import com.example.aop.ex01.service.BookService;
import com.example.generic_crud.CrudController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController extends CrudController<Book, Long>
{
	protected BookController(BookService service)
	{
		super(service);
	}

	@AspectAnnotation
	@GetMapping("/sub")
	public String subEndpoint()
	{
		return "Sub Endpoint";
	}
}
