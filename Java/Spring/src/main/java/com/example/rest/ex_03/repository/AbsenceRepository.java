package com.example.rest.ex_03.repository;

import com.example.rest.ex_03.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence, Long>
{
}
