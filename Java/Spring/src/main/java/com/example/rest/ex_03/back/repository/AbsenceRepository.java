package com.example.rest.ex_03.back.repository;

import com.example.rest.ex_03.back.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence, Long>
{
}
