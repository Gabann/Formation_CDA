package exercices;

import java.util.Scanner;

public class Exercice09
{
	public static void CountBetweenNumbers()
	{
		Scanner scanner = new Scanner(System.in);

		int numberA, numberB;

		System.out.println("Enter first number");
		numberA = scanner.nextInt();

		System.out.println("Enter second number");
		numberB = scanner.nextInt();

		for (int i = Math.min(numberA, numberB); i <= Math.max(numberA, numberB); i++)
		{
			System.out.println(i);
		}
	}
}
