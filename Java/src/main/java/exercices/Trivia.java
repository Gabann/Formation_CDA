package exercices;

import java.util.Scanner;

public class Trivia
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		final String wrongAnswer = "Wrong answer";

		String[] questions = {
				"Is the earth flat?",
				"Do penguins fly?",
				"Is the answer true?"
		};

		boolean[] answers = {
				false,
				false,
				true
		};

		for (int i = 0; i < questions.length; i++)
		{
			System.out.println(questions[i]);
			if (scanner.nextBoolean() != answers[i])
			{
				System.out.println(wrongAnswer);
				i = -1;
			}
		}

		System.out.println("You won");
	}
}
