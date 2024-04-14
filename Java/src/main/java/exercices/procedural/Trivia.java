package exercices.procedural;

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

		int index = 0;
		while (index < questions.length)
		{
			System.out.println(questions[index]);
			if (scanner.nextBoolean() != answers[index])
			{
				System.out.println(wrongAnswer);
				index = 0;
				continue;
			}

			index++;
		}

		System.out.println("You won");
	}
}
