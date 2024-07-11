package com.example.rest.ex_03.repository;

import com.example.rest.ex_03.entity.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepository extends JpaRepository<Vacation, Long>
{
}
