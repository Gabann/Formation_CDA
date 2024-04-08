package exercices;

import java.util.Scanner;

public class Exercice07
{
	public static void suggestActivityBasedOnMood()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("What's your current mood?");

		switch (input.next().toLowerCase())
		{
			case "sad":
			{
				System.out.println("Stay in bed or see your friends");
				break;
			}
			case "sleepy":
			{
				System.out.println("Have a nap or chill at home");
				break;
			}
			case "energetic":
			{
				System.out.println("Do sport or go outside");
				break;
			}
			default:
			{
				System.out.println("Wrong input");
			}
		}
	}
}
