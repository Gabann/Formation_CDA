package com.example.rest.ex_01.repository;

import com.example.rest.ex_01.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long>
{
	List<Todo> findByIsDone(Boolean isDone);
}
