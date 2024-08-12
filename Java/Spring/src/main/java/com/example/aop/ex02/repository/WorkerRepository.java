package com.example.aop.ex02.repository;

import com.example.aop.ex02.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long>
{
}
