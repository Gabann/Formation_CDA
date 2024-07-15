package com.example.rest.ex_02.controller;

import com.example.generic_crud.CrudController;
import com.example.rest.ex_02.dto.MovieDto;
import com.example.rest.ex_02.entity.Movie;
import com.example.rest.ex_02.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog/movies")
public class MovieController extends CrudController<Movie, Long>
{
	private final MovieService movieService;

	protected MovieController(MovieService service, MovieService movieService)
	{
		super(service);
		this.movieService = movieService;
	}

	@PostMapping("/create")
	public ResponseEntity<Movie> create(@RequestBody MovieDto movieDto)
	{
		Movie newMovie = movieService.create(movieDto);
		return ResponseEntity.ok(newMovie);
	}
}
