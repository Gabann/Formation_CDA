package exercices;

import java.time.LocalDate;

public class Exercice29
{
	public static void movies()
	{
		Movie movie1 = new Movie("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", LocalDate.of(2001, 1, 1), "Fantasy");

		movie1.describeMovie();
	}
}
