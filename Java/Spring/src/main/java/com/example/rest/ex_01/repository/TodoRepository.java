package com.example.rest.ex_01.repository;

import com.example.rest.ex_01.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>
{
}
