package exercices;

import java.util.Random;
import java.util.Scanner;

public class Exercice08
{
	public static void GuessNumber()
	{
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);

		int userGuess;
		int minRandomNumber = 1, maxRandomNumber = 100;
		int randomNumber = rand.nextInt(minRandomNumber, maxRandomNumber) + 1;

		do
		{
			System.out.println("Enter a number between 0 and 100");

			userGuess = scanner.nextInt();

			if (userGuess == randomNumber)
			{
				System.out.println("You won");
			}
			else
			{
				String greaterOrLowerString = userGuess > randomNumber ? "greater" : "lower";

				System.out.println("Your number is " + greaterOrLowerString + " than the number");
			}
		}
		while (userGuess != randomNumber);
	}
}
