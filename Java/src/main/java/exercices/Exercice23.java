package exercices;

public class Exercice23
{
	static int subtract(int minuend, int subtrahend)
	{
		System.out.printf("I subtract %d and %d %n", minuend, subtrahend);
		return minuend - subtrahend;
	}

	public static void run()
	{
		System.out.println(subtract(5, 3));
	}
}
