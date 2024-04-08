package exercices;

import java.util.Scanner;

public class Exercice02
{
	public static void calculateCandyCount()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Input candy price");
		float candyPrice = input.nextFloat();
		System.out.println("Input candy quantity");
		int candyCount = input.nextInt();
		System.out.println("Total price: " + candyCount * candyPrice);
	}
}
