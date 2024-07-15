package com.example.security.ex_01.repository;

import com.example.security.ex_01.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestEntityRepository extends JpaRepository<TestEntity, Long>
{
}
