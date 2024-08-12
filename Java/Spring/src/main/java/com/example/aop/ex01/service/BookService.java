package com.example.aop.ex01.service;

import com.example.aop.ex01.entity.Book;
import com.example.aop.ex01.repository.BookRepository;
import com.example.generic_crud.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BookService extends CrudServiceImpl<Book, Long>
{
	public BookService(BookRepository repository)
	{
		super(repository);
	}
}
