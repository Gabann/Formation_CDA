package com.example.rest.ex_02.dto;

import com.example.rest.ex_02.entity.Movie;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MovieDto
{
	Movie movie;
	Long directorId;
}
