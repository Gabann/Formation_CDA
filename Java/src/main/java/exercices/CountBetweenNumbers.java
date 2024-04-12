package exercices;

import java.util.Scanner;

public class CountBetweenNumbers
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		int numberA;
		int numberB;

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
