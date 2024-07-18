package com.example.springsecurityjwt.repository;

import com.example.springsecurityjwt.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long>
{
	@Override
	Optional<Todo> findById(Long aLong);
}
