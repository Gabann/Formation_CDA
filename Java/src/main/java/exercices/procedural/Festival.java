package exercices.procedural;

import java.util.Scanner;

public class Festival
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		int userStartingEnergy = 100;
		int userStartingTimeMinute = 60 * 8;

		int userCurrentEnergy = userStartingEnergy;
		int userCurrentTimeMinute = userStartingTimeMinute;

		int rockActivity1EnergyConsumption = 50;
		int rockActivity1TimeConsumptionMinute = 60 * 3;

		int rockActivity2EnergyConsumption = 30;
		int rockActivity2TimeConsumptionMinute = 60 * 2;

		int classicalActivity1EnergyConsumption = 80;
		int classicalActivity1TimeConsumptionMinute = 60 * 6;

		int classicalActivity2EnergyConsumption = 10;
		int classicalActivity2TimeConsumptionMinute = 60;

		int jazzActivity1EnergyConsumption = 100;
		int jazzActivity1TimeConsumptionMinute = 60 * 8;

		int jazzActivity2EnergyConsumption = 20;
		int jazzActivity2TimeConsumptionMinute = 60 * 3;

		int minActivityEnergyConsumption = Math.min(rockActivity1EnergyConsumption, rockActivity2EnergyConsumption);
		minActivityEnergyConsumption = Math.min(minActivityEnergyConsumption, classicalActivity1EnergyConsumption);
		minActivityEnergyConsumption = Math.min(minActivityEnergyConsumption, classicalActivity2EnergyConsumption);
		minActivityEnergyConsumption = Math.min(minActivityEnergyConsumption, jazzActivity1EnergyConsumption);
		minActivityEnergyConsumption = Math.min(minActivityEnergyConsumption, jazzActivity2EnergyConsumption);

		int minActivityTimeConsumptionMinute = Math.min(rockActivity1TimeConsumptionMinute, rockActivity2TimeConsumptionMinute);
		minActivityTimeConsumptionMinute = Math.min(minActivityTimeConsumptionMinute, classicalActivity1TimeConsumptionMinute);
		minActivityTimeConsumptionMinute = Math.min(minActivityTimeConsumptionMinute, classicalActivity2TimeConsumptionMinute);
		minActivityTimeConsumptionMinute = Math.min(minActivityTimeConsumptionMinute, jazzActivity1TimeConsumptionMinute);
		minActivityTimeConsumptionMinute = Math.min(minActivityTimeConsumptionMinute, jazzActivity2TimeConsumptionMinute);

		StringBuilder activityHistory = new StringBuilder();

		do
		{
			System.out.println("Select musical genre");
			System.out.println("1. Rock");
			System.out.println("2. Classical");
			System.out.println("3. Jazz");

			int genreUserInput = scanner.nextInt();

			switch (genreUserInput)
			{
				case 1:
				{
					System.out.println("Select an activity");
					System.out.printf("1. Activity a, takes %d energy and %d minutes %n", rockActivity1EnergyConsumption,
							rockActivity1TimeConsumptionMinute);
					System.out.printf("2. Activity b, takes %d energy and %d minutes %n", rockActivity2EnergyConsumption,
							rockActivity2TimeConsumptionMinute);

					int activityUserInput = scanner.nextInt();

					switch (activityUserInput)
					{
						case 1:
						{
							if (userCurrentTimeMinute >= rockActivity1TimeConsumptionMinute && userCurrentEnergy >= rockActivity1EnergyConsumption)
							{
								userCurrentEnergy -= rockActivity1EnergyConsumption;
								userCurrentTimeMinute -= rockActivity1TimeConsumptionMinute;
								activityHistory.append("Rock activity 1,");
							}
							else
							{
								System.out.println("You don't have enough energy or time to do this");
							}
							break;
						}
						case 2:
						{
							if (userCurrentTimeMinute >= rockActivity2TimeConsumptionMinute && userCurrentEnergy >= rockActivity2EnergyConsumption)
							{
								userCurrentEnergy -= rockActivity2EnergyConsumption;
								userCurrentTimeMinute -= rockActivity2TimeConsumptionMinute;
								activityHistory.append("Rock activity 2,");
							}
							else
							{
								System.out.println("You don't have enough energy or time to do this");
							}

							break;
						}
						default:
						{
							System.out.println("Wrong input");
						}
					}

					break;
				}
				case 2:
				{
					System.out.println("Select an activity");
					System.out.printf("1. Activity a, takes %d energy and %d minutes %n", classicalActivity1EnergyConsumption,
							classicalActivity1TimeConsumptionMinute);
					System.out.printf("2. Activity b, takes %d energy and %d minutes %n", classicalActivity2EnergyConsumption,
							classicalActivity2TimeConsumptionMinute);

					int activityUserInput = scanner.nextInt();

					switch (activityUserInput)
					{
						case 1:
						{
							if (userCurrentTimeMinute >= classicalActivity1TimeConsumptionMinute && userCurrentEnergy >= classicalActivity1EnergyConsumption)
							{
								userCurrentEnergy -= classicalActivity1EnergyConsumption;
								userCurrentTimeMinute -= classicalActivity1TimeConsumptionMinute;
								activityHistory.append("Classical activity 1,");
							}
							else
							{
								System.out.println("You don't have enough energy or time to do this");
							}

							break;
						}
						case 2:
						{
							if (userCurrentTimeMinute >= classicalActivity2TimeConsumptionMinute && userCurrentEnergy >= classicalActivity2EnergyConsumption)
							{
								userCurrentEnergy -= classicalActivity2EnergyConsumption;
								userCurrentTimeMinute -= classicalActivity2TimeConsumptionMinute;
								activityHistory.append("Classical activity 2,");
							}
							else
							{
								System.out.println("You don't have enough energy or time to do this");
							}

							break;
						}
						default:
						{
							System.out.println("Wrong input");
						}
					}

					break;
				}
				case 3:
				{
					System.out.println("Select an activity");
					System.out.printf("1. Activity a, takes %d energy and %d minutes %n", jazzActivity1EnergyConsumption,
							jazzActivity1TimeConsumptionMinute);
					System.out.printf("2. Activity b, takes %d energy and %d minutes %n", jazzActivity2EnergyConsumption,
							jazzActivity2TimeConsumptionMinute);

					int activityUserInput = scanner.nextInt();

					switch (activityUserInput)
					{
						case 1:
						{
							if (userCurrentTimeMinute >= jazzActivity1TimeConsumptionMinute && userCurrentEnergy >= jazzActivity1EnergyConsumption)
							{
								userCurrentEnergy -= jazzActivity1EnergyConsumption;
								userCurrentTimeMinute -= jazzActivity1TimeConsumptionMinute;
								activityHistory.append("Jazz activity 1,");
							}
							else
							{
								System.out.println("You don't have enough energy or time to do this");
							}

							break;
						}
						case 2:
						{
							if (userCurrentTimeMinute >= jazzActivity2TimeConsumptionMinute && userCurrentEnergy >= jazzActivity2EnergyConsumption)
							{
								userCurrentEnergy -= jazzActivity2EnergyConsumption;
								userCurrentTimeMinute -= jazzActivity2TimeConsumptionMinute;
								activityHistory.append("Jazz activity 2,");
							}
							else
							{
								System.out.println("You don't have enough energy or time to do this");
							}

							break;
						}
						default:
						{
							System.out.println("Wrong input");
						}
					}

					break;
				}

				default:
				{
					System.out.println("Wrong input");
				}
			}

			System.out.printf("You have %d energy and %d minutes left %n", userCurrentEnergy, userCurrentTimeMinute);
		} while (userCurrentTimeMinute > minActivityTimeConsumptionMinute && userCurrentEnergy > minActivityEnergyConsumption);

		System.out.println("You don't have enough energy or time to continue");
		System.out.printf("You went to: %s", activityHistory);
	}
}
