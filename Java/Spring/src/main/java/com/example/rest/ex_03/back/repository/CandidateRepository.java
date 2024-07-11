package com.example.rest.ex_03.back.repository;

import com.example.rest.ex_03.back.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long>
{
}
