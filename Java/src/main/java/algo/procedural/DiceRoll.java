package algo.procedural;

import java.util.Random;

public class DiceRoll
{
	private static final Random random = new Random();

	public static void main(String[] args)
	{
		int userScore = 0;
		int computerScore = 0;
		int scoreToWin = 20;

		while (userScore <= scoreToWin && computerScore <= scoreToWin)
		{
			int diceRoll = random.nextInt(1, 6);
			userScore += diceRoll;
			System.out.printf("User rolled %d and is now at %d%n", diceRoll, userScore);

			diceRoll = random.nextInt(1, 6);
			computerScore += diceRoll;
			System.out.printf("Computer rolled %d and is now at %d%n", diceRoll, computerScore);
		}

		System.out.printf("User score: %d%n", userScore);
		System.out.printf("Computer score: %d%n", computerScore);

		if (userScore > computerScore)
		{
			System.out.println("User wins");
		}
		else if (userScore < computerScore)
		{
			System.out.println("computer wins");

		}
		else
		{
			System.out.println("Draw");

		}
	}
}
