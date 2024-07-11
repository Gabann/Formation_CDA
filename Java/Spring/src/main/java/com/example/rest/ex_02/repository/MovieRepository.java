package com.example.rest.ex_02.repository;

import com.example.rest.ex_02.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Long>
{
	List<Movie> findByDirector_Id(Long id);
}
