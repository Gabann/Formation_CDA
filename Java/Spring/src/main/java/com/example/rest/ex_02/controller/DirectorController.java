package com.example.rest.ex_02.controller;

import com.example.rest.ex_02.entity.Director;
import com.example.rest.ex_02.entity.Movie;
import com.example.rest.ex_02.service.DirectorService;
import com.example.rest.ex_02.service.MovieService;
import com.example.rest.generic_crud.CrudController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("catalog/directors")
public class DirectorController extends CrudController<Director, Long>
{
	private final MovieService movieService;
	private final DirectorService directorService;

	protected DirectorController(DirectorService service, MovieService movieService, DirectorService directorService)
	{
		super(service);
		this.movieService = movieService;
		this.directorService = directorService;
	}

	@GetMapping("/{directorId}/movies")
	public ResponseEntity<List<Movie>> getMoviesByDirector(@PathVariable String directorId)
	{
		List<Movie> movieList = (List<Movie>) movieService.getAll();

		List<Movie> directorMovies = movieList.stream()
				.filter(movie -> movie.getDirector() == directorService.getById(Long.valueOf(directorId)).orElse(null)).toList();

		return new ResponseEntity<>(directorMovies, HttpStatus.OK);
	}
}
