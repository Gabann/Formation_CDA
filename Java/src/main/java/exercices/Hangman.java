package exercices;

import java.util.Scanner;

public class Hangman
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String wordToGuess = "computer".toLowerCase();
		int userAttemptCount = 5;

		StringBuilder wordInfo = new StringBuilder();

		//Should be an array but here we are...
		StringBuilder guessedChars = new StringBuilder();


		while (userAttemptCount > 0 && !wordToGuess.contentEquals(wordInfo))
		{
			wordInfo.setLength(0);

			for (int i = 0; i < wordToGuess.length(); i++)
			{
				char currentChar = wordToGuess.charAt(i);

				if (guessedChars.toString().contains(Character.toString(currentChar)))
				{
					wordInfo.append(currentChar);
				}
				else
				{
					wordInfo.append("*");
				}
			}

			System.out.printf("Word info: %s%n", wordInfo);
			System.out.printf("GuessedChars: %s%n", guessedChars);
			System.out.printf("You have %d attempts left%n", userAttemptCount);


			System.out.println("What character would you like to guess?");
			char userCharInput = scanner.next().toLowerCase().charAt(0);

			if (!guessedChars.toString().contains(Character.toString(userCharInput)))
			{
				guessedChars.append(userCharInput);

				if (!wordToGuess.contains(Character.toString(userCharInput)))
				{
					userAttemptCount--;
				}
			}
		}

		System.out.println("The secret word was " + wordToGuess);

		if (userAttemptCount == 0)
		{
			System.out.println("You lost");
		}
		else
		{
			System.out.println("You won");
		}
	}
}
