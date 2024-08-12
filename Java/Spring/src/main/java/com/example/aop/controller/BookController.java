package com.example.aop.controller;

import com.example.aop.entity.Book;
import com.example.aop.service.BookService;
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

	@GetMapping("/sub")
	public String subEndpoint()
	{
		return "Sub Endpoint";
	}
}
