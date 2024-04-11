package exercices;

import java.util.Scanner;

public class Exercice10
{
	public static void run()
	{
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < 3; i++)
		{
			switch (i)
			{
				case 0:
				{
					System.out.println("Is the earth flat?");
					if (scanner.nextBoolean())
					{
						System.out.println("Wrong answer");
						i = -1;
					}
					break;
				}
				case 1:
				{
					System.out.println("Do penguiuns fly?");
					if (scanner.nextBoolean())
					{
						System.out.println("Wrong answer");
						i = -1;
					}
					break;
				}
				case 2:
				{
					System.out.println("Is the answer true?");
					if (!scanner.nextBoolean())
					{
						System.out.println("Wrong answer");
						i = -1;
					}
					break;
				}
			}
		}

		System.out.println("You won");
	}
}
