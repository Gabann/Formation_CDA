package com.example.rest.ex_02.repository;

import com.example.rest.ex_02.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long>
{

}
