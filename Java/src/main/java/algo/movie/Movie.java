package algo.movie;

import java.time.LocalDate;

public class Movie
{
	String title;
	String director;
	LocalDate releaseYear;
	String genre;

	public Movie(String title, String director, LocalDate releaseYear, String genre)
	{
		this.title = title;
		this.director = director;
		this.releaseYear = releaseYear;
		this.genre = genre;
	}

	public void describeMovie()
	{
		System.out.printf("Film {title='%s', director='%s', releaseYear='%s', genre='%s'}", title, director, releaseYear.toString(),
				genre);
	}
}
