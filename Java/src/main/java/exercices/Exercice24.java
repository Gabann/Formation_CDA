package exercices;

public class Exercice24
{
	static void whatHour()
	{
		whatHour("12h00");
	}

	static void whatHour(String hour)
	{
		System.out.printf("It is %s o'clock%n", hour);
	}

	public static void run()
	{
		whatHour();
		whatHour("14h00");
	}
}
