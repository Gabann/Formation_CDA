package exercices;

import java.util.Random;
import java.util.Scanner;

public class Exercice21
{
	public static void battleship()
	{
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int boardSize = 2;

		boolean[][] playerBoard = new boolean[boardSize][boardSize];
		boolean[][] computerBoard = new boolean[boardSize][boardSize];

		computerBoard[random.nextInt(boardSize)][random.nextInt(boardSize)] = true;

		int lineIndexInput;
		do
		{
			System.out.println("Enter the line where you want to place your ship (0 to " + (boardSize - 1) + ")");
			lineIndexInput = scanner.nextInt();
		} while (lineIndexInput < 0 || lineIndexInput >= boardSize);

		int columnIndexInput;
		do
		{
			System.out.println("Enter the column where you want to place your ship (0 to " + (boardSize - 1) + ")");
			columnIndexInput = scanner.nextInt();
		} while (columnIndexInput < 0 || columnIndexInput >= boardSize);

		playerBoard[lineIndexInput][columnIndexInput] = true;

		boolean isPlayerTurn = true;
		boolean doesPlayerHaveShipsLeft = true;
		boolean doesComputerHaveShipsLeft = true;

		do
		{
			do
			{
				System.out.println("Enter the line where you want to shoot(0 to " + (boardSize - 1) + ")");
				lineIndexInput = scanner.nextInt();
			}
			while (lineIndexInput < 0 || lineIndexInput >= boardSize);

			do
			{
				System.out.println("Enter the line where you want shoot (0 to " + (boardSize - 1) + ")");
				columnIndexInput = scanner.nextInt();
			}
			while (columnIndexInput < 0 || columnIndexInput >= boardSize);

			System.out.printf("You shot at [%d,%d]%n", lineIndexInput, columnIndexInput);

			if (computerBoard[lineIndexInput][columnIndexInput])
			{
				System.out.println("You hit a ship!");
				computerBoard[lineIndexInput][columnIndexInput] = false;
			}
			else
			{
				System.out.println("You didn't hit anything");
			}

			doesComputerHaveShipsLeft = false;
			for (int i = 0; i < computerBoard.length; i++)
			{
				for (int j = 0; j < computerBoard[i].length; j++)
				{
					if (computerBoard[i][j])
					{
						doesComputerHaveShipsLeft = true;
						break;
					}
				}
			}

			if (!doesComputerHaveShipsLeft)
			{
				break;
			}

			int computerShootingLine = random.nextInt(boardSize);
			int computerShootingColumn = random.nextInt(boardSize);

			System.out.printf("Computer is shooting at [%d,%d]%n", computerShootingLine, computerShootingColumn);

			if (playerBoard[computerShootingLine][computerShootingColumn])
			{
				System.out.println("Computer has hit your ship!");
				playerBoard[computerShootingLine][computerShootingColumn] = false;
			}
			else
			{
				System.out.println("Computer missed");
			}

			doesPlayerHaveShipsLeft = false;
			for (int i = 0; i < playerBoard.length; i++)
			{
				for (int j = 0; j < playerBoard[i].length; j++)
				{
					if (playerBoard[i][j])
					{
						doesPlayerHaveShipsLeft = true;
						break;
					}
				}
			}

			if (!doesPlayerHaveShipsLeft)
			{
				break;
			}

		}
		while (doesComputerHaveShipsLeft && doesPlayerHaveShipsLeft);

		String winner = doesPlayerHaveShipsLeft ? "Player" : "Computer";

		System.out.printf("%s wins", winner);
	}
}
