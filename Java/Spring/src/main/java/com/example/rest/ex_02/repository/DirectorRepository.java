package com.example.rest.ex_02.repository;

import com.example.rest.ex_02.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long>
{
}
