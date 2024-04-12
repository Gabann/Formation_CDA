package exercices.movie;

import java.time.LocalDate;

public class Main
{
	public static void main(String[] args)
	{
		Movie movie1 = new Movie("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", LocalDate.of(2001, 1, 1), "Fantasy");

		movie1.describeMovie();
	}
}
