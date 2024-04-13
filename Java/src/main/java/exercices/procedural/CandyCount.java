package exercices.procedural;

import java.util.Scanner;

public class CandyCount
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Input candy price");
		float candyPrice = input.nextFloat();
		System.out.println("Input candy quantity");
		int candyCount = input.nextInt();
		System.out.println("Total price: " + candyCount * candyPrice);
	}
}
