package exercices;

import java.util.Scanner;

public class Exercice18
{
	public static void memory()
	{
		Scanner scanner = new Scanner(System.in);

		int[] secretArray = {5, 1, 2, 4, 3, 4, 5, 1, 3, 2};
		boolean[] foundIndexesArray = new boolean[secretArray.length];
		boolean allIndexesFound = false;

		while (!allIndexesFound)
		{
			System.out.print("[");
			for (int i = 0; i < secretArray.length; i++)
			{
				if (foundIndexesArray[i])
				{
					System.out.print(secretArray[i] + ",");
				}
				else
				{
					System.out.print("?,");
				}
			}
			System.out.println("]");

			System.out.println("Enter first index");
			int userIndexInput1 = scanner.nextInt();

			System.out.printf("You flipped index %d and revealed %d\n", userIndexInput1, secretArray[userIndexInput1]);

			System.out.print("[");
			for (int i = 0; i < secretArray.length; i++)
			{
				if (foundIndexesArray[i] || userIndexInput1 == i)
				{
					System.out.print(secretArray[i] + ",");
				}
				else
				{
					System.out.print("?,");
				}
			}
			System.out.println("]");

			System.out.println("Enter second index");
			int userIndexInput2 = scanner.nextInt();

			System.out.printf("You flipped index %d and revealed %d\n", userIndexInput2, secretArray[userIndexInput2]);

			System.out.print("[");
			for (int i = 0; i < secretArray.length; i++)
			{
				if (foundIndexesArray[i] || userIndexInput1 == i || userIndexInput2 == i)
				{
					System.out.print(secretArray[i] + ",");
				}
				else
				{
					System.out.print("?,");
				}
			}
			System.out.println("]");

			if (secretArray[userIndexInput1] == secretArray[userIndexInput2])
			{
				System.out.printf("Indexes %d and %d both got the value %d\n", userIndexInput1, userIndexInput2,
						secretArray[userIndexInput1]);
				foundIndexesArray[userIndexInput1] = true;
				foundIndexesArray[userIndexInput2] = true;
			}
			else
			{
				System.out.printf("Indexes %d and %d don't have the same values\n", userIndexInput1, userIndexInput2);
			}

			//Horrible code because we can't use functions...
			allIndexesFound = true;
			for (boolean value : foundIndexesArray)
			{
				if (!value)
				{
					allIndexesFound = false;
					break;
				}
			}
		}

		System.out.println("You win");
	}
}
