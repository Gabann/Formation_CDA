package com.example.rest.ex_02.service;

import com.example.rest.ex_02.dto.MovieDto;
import com.example.rest.ex_02.entity.Director;
import com.example.rest.ex_02.entity.Movie;
import com.example.rest.ex_02.repository.DirectorRepository;
import com.example.rest.ex_02.repository.MovieRepository;
import com.example.rest.generic_crud.CrudServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService extends CrudServiceImpl<Movie, Long>
{
	private final DirectorRepository directorRepository;
	private final MovieRepository movieRepository;

	public MovieService(MovieRepository repository, MovieRepository movieRepository, DirectorRepository directorRepository)
	{
		super(repository);
		this.movieRepository = movieRepository;
		this.directorRepository = directorRepository;
	}

	public Movie create(MovieDto movieDto)
	{
		Director director = directorRepository.findById(movieDto.getDirectorId())
				.orElseThrow(() -> new RuntimeException("Director not found"));

		Movie newMovie = movieDto.getMovie();

		newMovie.setDirector(director);

		return movieRepository.save(newMovie);
	}

	public List<Movie> getMovieByDirector(Long directorId)
	{
		return movieRepository.findByDirector_Id(directorId);
	}
}
