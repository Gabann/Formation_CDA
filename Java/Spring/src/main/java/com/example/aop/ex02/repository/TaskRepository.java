package com.example.aop.ex02.repository;

import com.example.aop.ex02.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>
{
	@Override
	Optional<Task> findById(Long aLong);
}
