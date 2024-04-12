package exercices.movie;

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

	private String getTitle()
	{
		return title;
	}

	private void setTitle(String title)
	{
		this.title = title;
	}

	private String getDirector()
	{
		return director;
	}

	private void setDirector(String director)
	{
		this.director = director;
	}

	private LocalDate getReleaseYear()
	{
		return releaseYear;
	}

	private void setReleaseYear(LocalDate releaseYear)
	{
		this.releaseYear = releaseYear;
	}

	private String getGenre()
	{
		return genre;
	}

	private void setGenre(String genre)
	{
		this.genre = genre;
	}

	public void describeMovie()
	{
		System.out.printf("Film {title='%s', director='%s', releaseYear='%s', genre='%s'}", title, director, releaseYear.toString(),
				genre);
	}
}
