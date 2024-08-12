package com.example.aop.service;

import com.example.aop.entity.Book;
import com.example.aop.repository.BookRepository;
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
