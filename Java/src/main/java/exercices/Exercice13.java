package exercices;

import java.util.Scanner;

public class Exercice13
{
	public static void rockPaperScissorsV1()
	{
		Scanner scanner = new Scanner(System.in);
		int rng = (int) (Math.random() * 3) + 1;

		String computerChoice = "";
		switch (rng)
		{
			case 1:
			{
				computerChoice = "Rock";
				break;
			}
			case 2:
			{
				computerChoice = "Paper";
				break;
			}
			case 3:
			{
				computerChoice = "Scissors";
				break;
			}
			default:
			{
				System.out.println("Something went wrong");
			}
		}

		System.out.println("Select your sign");
		System.out.println("1. Rock");
		System.out.println("2. Paper");
		System.out.println("3. Scissors");

		int userMenuInput = scanner.nextInt();

		String userChoice;

		System.out.println("Computer choosed " + computerChoice);

		switch (userMenuInput)
		{
			case 1:
			{
				userChoice = "Rock";

				System.out.println("You choosed " + userChoice);

				if (computerChoice.equals("Rock"))
				{
					System.out.println("Draw");
				}

				if (computerChoice.equals("Paper"))
				{
					System.out.println("You lose");
				}

				if (computerChoice.equals("Scissors"))
				{
					System.out.println("You win");
				}

				break;
			}
			case 2:
			{
				userChoice = "Paper";

				System.out.println("You choosed " + userChoice);

				if (computerChoice.equals("Rock"))
				{
					System.out.println("You win");
				}

				if (computerChoice.equals("Paper"))
				{
					System.out.println("Draw");
				}

				if (computerChoice.equals("Scissors"))
				{
					System.out.println("You lose");
				}

				break;
			}
			case 3:
			{
				userChoice = "Scissors";

				System.out.println("You choosed " + userChoice);

				if (computerChoice.equals("Rock"))
				{
					System.out.println("You lose");
				}

				if (computerChoice.equals("Paper"))
				{
					System.out.println("You win");
				}

				if (computerChoice.equals("Scissors"))
				{
					System.out.println("Draw");
				}

				break;
			}
			default:
			{
				System.out.println("Wrong input");
			}
		}
	}

	public static void rockPaperScissorsV2()
	{
		Scanner scanner = new Scanner(System.in);

		String[] choices = {"Rock", "Paper", "Scissors"};

		int rng = (int) (Math.random() * 3);

		String computerChoice = choices[rng];

		System.out.println("Select your sign");
		System.out.println("1. Rock");
		System.out.println("2. Paper");
		System.out.println("3. Scissors");

		int userMenuInput = scanner.nextInt();
		String userChoice = choices[userMenuInput - 1];

		System.out.println("You choosed " + userChoice);
		System.out.println("Computer choosed " + computerChoice);

		if (userChoice.equals(computerChoice))
		{
			System.out.println("Draw");
		}
		else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
				(userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
				(userChoice.equals("Scissors") && computerChoice.equals("Paper")))
		{
			System.out.println("You win");
		}
		else
		{
			System.out.println("You lose");
		}
	}
}
