package algo.procedural;

import java.util.Scanner;

public class LeftOrRightChoice
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Left or right?");

		String directionInput = input.next().toLowerCase();

		if (directionInput.equals("right"))
		{
			System.out.println("You died");
		}
		else if (directionInput.equals("left"))
		{
			System.out.println("You come across a new choice");

			System.out.println("Left or right?");

			directionInput = input.next().toLowerCase();

			if (directionInput.equals("right"))
			{
				System.out.println("You died");
			}
			else if (directionInput.equals("left"))
			{
				System.out.println("You found a treasure");
			}
			else
			{
				System.out.println("Wrong input");
			}
		}
		else
		{
			System.out.println("Wrong input");
		}
	}
}
