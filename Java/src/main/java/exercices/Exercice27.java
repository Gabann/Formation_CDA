package exercices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercice27
{
	static Scanner scanner = new Scanner(System.in);

	static int userStartingEnergy = 100;
	static int userStartingTimeMinute = 60 * 8;

	static int userCurrentEnergy = userStartingEnergy;
	static int userCurrentTimeMinute = userStartingTimeMinute;
	static List<String> activityHistory = new ArrayList<>();

	static String[][] activities = {
			{"Rock activity 1", "Rock activity 2"},
			{"Classical activity 1", "Classical activity 2"},
			{"Jazz activity 1", "Jazz activity 2"}
	};

	static int[][] activityEnergyConsumptions = {
			{50, 30},
			{80, 10},
			{100, 20}
	};

	static int[][] activityTimeConsumptions = {
			{60 * 3, 60 * 2},
			{60 * 6, 60},
			{60 * 8, 60 * 3}
	};

	static void setUserEnergy(int newValue)
	{
		if (newValue > userStartingEnergy)
		{
			newValue = userStartingEnergy;
		}

		userCurrentEnergy = newValue;
	}

	static void setUserTime(int newValue)
	{
		if (newValue > userStartingTimeMinute)
		{
			newValue = userStartingTimeMinute;
		}

		userCurrentTimeMinute = newValue;
	}


	static void doActivity(int activityEnergyConsumption, int activityTimeConsumption, String activityName)
	{
		if (userCurrentEnergy >= activityEnergyConsumption && userCurrentTimeMinute >= activityTimeConsumption)
		{
			setUserEnergy(userCurrentEnergy -= activityEnergyConsumption);
			setUserTime(userCurrentTimeMinute -= activityTimeConsumption);
			activityHistory.add(activityName);
		}
		else
		{
			System.out.println("You don't have enough energy or time to do this");
		}
	}

	static int askMenuInput(String menu, int inputLowerBound, int inputUpperBound)
	{
		System.out.println(menu);

		int input;
		do
		{
			input = scanner.nextInt();
			if (input > inputUpperBound || input < inputLowerBound)
			{
				System.out.printf("Input should be between %d and %d%n", inputLowerBound, inputUpperBound);
			}
		}
		while (input > inputUpperBound || input < inputLowerBound);
		return input;
	}

	static int askMenuInput(String menu, int inputUpperBound)
	{
		return askMenuInput(menu, 1, inputUpperBound);
	}

	public static int findSmallestValueIn2DArray(int[][] array)
	{
		int smallestValue = array[0][0];

		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				if (array[i][j] < smallestValue)
				{
					smallestValue = array[i][j];
				}
			}
		}

		return smallestValue;
	}

	public static void festivalFunction()
	{
		int minActivityTimeConsumptionMinute = findSmallestValueIn2DArray(activityTimeConsumptions);
		int minActivityEnergyConsumption = findSmallestValueIn2DArray(activityEnergyConsumptions);

		do
		{
			int genreUserInput = askMenuInput(
					"Select musical genre\n" +
							"1. Rock\n" +
							"2. Classical\n" +
							"3. Jazz",
					3);

			StringBuilder activityMenu = new StringBuilder("Select an activity\n");
			for (int i = 0; i < activities[genreUserInput - 1].length; i++)
			{
				activityMenu.append(String.format("%d. %s, takes %d energy and %d minutes%n",
						i + 1, activities[genreUserInput - 1][i], activityEnergyConsumptions[genreUserInput - 1][i], activityTimeConsumptions[genreUserInput - 1][i]));
			}

			int activityUserInput = askMenuInput(activityMenu.toString(), activities[genreUserInput - 1].length);

			doActivity(activityEnergyConsumptions[genreUserInput - 1][activityUserInput - 1], activityTimeConsumptions[genreUserInput - 1][activityUserInput - 1], activities[genreUserInput - 1][activityUserInput - 1]);

			System.out.printf("You have %d energy and %d minutes left %n", userCurrentEnergy, userCurrentTimeMinute);

		} while (userCurrentTimeMinute > minActivityTimeConsumptionMinute && userCurrentEnergy > minActivityEnergyConsumption);

		System.out.println("You don't have enough energy or time to continue");
		System.out.printf("You went to: %s", activityHistory);
	}
}
