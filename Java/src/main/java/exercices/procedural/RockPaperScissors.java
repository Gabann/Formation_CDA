package exercices.procedural;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors
{
	private static final Random random = new Random();

	public static void main(String[] args)
	{
//		v1();
		v2();
	}

//	static void v1()
//	{
//		Scanner scanner = new Scanner(System.in);
//		int rng = (int) (Math.random() * 3) + 1;
//
//		String computerChoice = "";
//		switch (rng)
//		{
//			case 1:
//			{
//				computerChoice = "Rock";
//				break;
//			}
//			case 2:
//			{
//				computerChoice = "Paper";
//				break;
//			}
//			case 3:
//			{
//				computerChoice = "Scissors";
//				break;
//			}
//			default:
//			{
//				System.out.println("Something went wrong");
//			}
//		}
//
//		System.out.println("Select your sign");
//		System.out.println("1. Rock");
//		System.out.println("2. Paper");
//		System.out.println("3. Scissors");
//
//		int userMenuInput = scanner.nextInt();
//
//		String userChoice;
//
//		System.out.println("Computer has chosen " + computerChoice);
//
//		switch (userMenuInput)
//		{
//			case 1:
//			{
//				userChoice = "Rock";
//
//				System.out.println("You have chosen " + userChoice);
//
//				if (computerChoice.equals("Rock"))
//				{
//					System.out.println("Draw");
//				}
//
//				if (computerChoice.equals("Paper"))
//				{
//					System.out.println("You lose");
//				}
//
//				if (computerChoice.equals("Scissors"))
//				{
//					System.out.println("You win");
//				}
//
//				break;
//			}
//			case 2:
//			{
//				userChoice = "Paper";
//
//				System.out.println("You have chosen " + userChoice);
//
//				if (computerChoice.equals("Rock"))
//				{
//					System.out.println("You win");
//				}
//
//				if (computerChoice.equals("Paper"))
//				{
//					System.out.println("Draw");
//				}
//
//				if (computerChoice.equals("Scissors"))
//				{
//					System.out.println("You lose");
//				}
//
//				break;
//			}
//			case 3:
//			{
//				userChoice = "Scissors";
//
//				System.out.println("You have chosen " + userChoice);
//
//				if (computerChoice.equals("Rock"))
//				{
//					System.out.println("You lose");
//				}
//
//				if (computerChoice.equals("Paper"))
//				{
//					System.out.println("You win");
//				}
//
//				if (computerChoice.equals("Scissors"))
//				{
//					System.out.println("Draw");
//				}
//
//				break;
//			}
//			default:
//			{
//				System.out.println("Wrong input");
//			}
//		}
//	}

	public static void v2()
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
