package exercices;

import java.util.Scanner;

public class Exercice17
{
	public static void searchInArray()
	{
		Scanner scanner = new Scanner(System.in);

		int[] array = {1, 2, 3, 4, 5, 1, 3, 2};

		System.out.println("Enter number to search");
		int userInput = scanner.nextInt();

		boolean numberFound = false;

		for (int i = 0; i < array.length; i++)
		{
			if (array[i] == userInput)
			{
				System.out.printf("%d is in the array at index %d\n", userInput, i);
				numberFound = true;
			}

		}
		if (!numberFound)
		{
			System.out.printf("%d is not in the array", userInput);
		}
	}
}
