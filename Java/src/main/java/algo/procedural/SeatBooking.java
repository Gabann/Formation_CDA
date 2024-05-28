package algo.procedural;

import java.util.Scanner;

public class SeatBooking
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		boolean[] seatArray = new boolean[100];

		System.out.println("Enter seat you want to book (-1 to quit)");
		int userInput = scanner.nextInt();

		while (userInput != -1)
		{
			if (!seatArray[userInput])
			{
				seatArray[userInput] = true;
				System.out.printf("You reserved the seat %d%n", userInput);
			}
			else
			{
				System.out.printf("Seat %d is already reserved%n", userInput);
			}

			System.out.println("Enter seat you want to book (-1 to quit)");
			userInput = scanner.nextInt();
		}

		System.out.println("Goodbye");
	}
}
