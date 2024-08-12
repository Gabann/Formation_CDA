package com.example.aop.ex01.repository;

import com.example.aop.ex01.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>
{

}
