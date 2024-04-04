package Exercices;

public class Exercice15
{
	public static void DiceRoll()
	{
		int userScore = 0, computerScore = 0, scoreToWin = 20;

		while (userScore <= scoreToWin && computerScore <= scoreToWin)
		{
			int diceRoll = (int) (Math.random() * 6) + 1;
			userScore += diceRoll;
			System.out.printf("User rolled %d and is now at %d\n", diceRoll, userScore);

			diceRoll = (int) (Math.random() * 6) + 1;
			computerScore += diceRoll;
			System.out.printf("Computer rolled %d and is now at %d\n", diceRoll, computerScore);
		}

		System.out.printf("User score: %d\n", userScore);
		System.out.printf("Computer score: %d\n", computerScore);

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
