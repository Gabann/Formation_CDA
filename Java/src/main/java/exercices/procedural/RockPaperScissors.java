package exercices.procedural;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors
{
	private static final Random random = new Random();

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		String[] choices = {"Rock", "Paper", "Scissors"};
		String[] results = {"Draw", "You win", "You lose"};

		int[][] gameRules = {
				{0, 2, 1},  // Rock
				{1, 0, 2},  // Paper
				{2, 1, 0}   // Scissors
		};

		int computerChoice = random.nextInt(0, choices.length);

		System.out.println("Select your sign");
		System.out.println("1. " + choices[0]);
		System.out.println("2. " + choices[1]);
		System.out.println("3. " + choices[2]);

		int playerChoice = scanner.nextInt() - 1;

		System.out.println("You have chosen " + choices[playerChoice]);
		System.out.println("Computer has chosen " + choices[computerChoice]);

		int result = gameRules[playerChoice][computerChoice];

		System.out.println(results[result]);
	}
}
