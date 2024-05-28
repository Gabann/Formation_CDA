package algo.procedural;

import java.util.Random;
import java.util.Scanner;

public class BattleShip
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int boardSize = 5;
		int numberOfShips = 3;
		int minShipSize = 2;
		int maxShipSize = 3;
		int[] shipsSizes = new int[numberOfShips];
		boolean[][] playerBoard = new boolean[boardSize][boardSize];
		boolean[][] computerBoard = new boolean[boardSize][boardSize];

		for (int i = 0; i < numberOfShips; i++)
		{
			shipsSizes[i] = random.nextInt(minShipSize, maxShipSize);
		}

		for (int i = 0; i < numberOfShips; )
		{
			int shipPlacementIndexLine;
			int shipPlacementIndexColumn;

			int shipSize = shipsSizes[i];
			do
			{
				shipPlacementIndexLine = random.nextInt(boardSize);
				shipPlacementIndexColumn = random.nextInt(boardSize);
			}
			while (computerBoard[shipPlacementIndexLine][shipPlacementIndexColumn]);


			int direction = random.nextInt(1, 4);

			//BUG computer can place ships in top of each others
			switch (direction)
			{
				//Up
				case 1 ->
				{
					if (shipPlacementIndexLine - (shipSize - 1) >= 0)
					{
						for (int j = 0; j < shipSize; j++)
						{
							computerBoard[shipPlacementIndexLine - j][shipPlacementIndexColumn] = true;

						}
						i++;
					}
					else
					{
						System.out.println("You don't have enough space to place your ship");
					}
				}
				//Down
				case 2 ->
				{
					if (shipPlacementIndexLine + (shipSize - 1) <= boardSize - 1)
					{
						for (int j = 0; j < shipSize; j++)
						{
							computerBoard[shipPlacementIndexLine + j][shipPlacementIndexColumn] = true;
						}
						i++;
					}
					else
					{
						System.out.println("You don't have enough space to place your ship");
					}
				}
				//Left
				case 3 ->
				{
					if (shipPlacementIndexColumn - (shipSize - 1) >= 0)
					{
						for (int j = 0; j < shipSize; j++)
						{
							computerBoard[shipPlacementIndexLine][shipPlacementIndexColumn - j] = true;
						}
						i++;
					}
					else
					{
						System.out.println("You don't have enough space to place your ship");
					}
				}
				//Right
				case 4 ->
				{
					if (shipPlacementIndexColumn + (shipSize - 1) <= boardSize - 1)
					{
						for (int j = 0; j < shipSize; j++)
						{
							computerBoard[shipPlacementIndexLine][shipPlacementIndexColumn + j] = true;
						}
						i++;
					}
					else
					{
						System.out.println("You don't have enough space to place your ship");
					}
				}
				default -> throw new IllegalStateException("Unexpected value: " + direction);
			}

		}

		System.out.println("Computer board");
		for (int j = 0; j < computerBoard.length; j++)
		{
			for (int n = 0; n < computerBoard[j].length; n++)
			{
				if (computerBoard[j][n])
				{
					System.out.print("X ");
				}
				else
				{
					System.out.print("- ");
				}
			}
			System.out.println();
		}

		int lineIndexInput;
		int columnIndexInput;
		for (int i = 0; i < numberOfShips; i++)
		{
			do
			{
				do
				{
					System.out.println("Enter the line where you want to place your ship (0 to " + (boardSize - 1) + ")");
					lineIndexInput = scanner.nextInt();
				} while (lineIndexInput < 0 || lineIndexInput >= boardSize);

				do
				{
					System.out.println("Enter the column where you want to place your ship (0 to " + (boardSize - 1) + ")");
					columnIndexInput = scanner.nextInt();
				} while (columnIndexInput < 0 || columnIndexInput >= boardSize);
			}
			while (playerBoard[lineIndexInput][columnIndexInput]);

			playerBoard[lineIndexInput][columnIndexInput] = true;

			System.out.println("Player board");
			for (int j = 0; j < playerBoard.length; j++)
			{
				for (int n = 0; n < playerBoard[j].length; n++)
				{
					if (playerBoard[j][n])
					{
						System.out.print("X ");
					}
					else
					{
						System.out.print("- ");
					}
				}
				System.out.println();
			}
		}

		boolean doesPlayerHaveShipsLeft = true;
		boolean doesComputerHaveShipsLeft = true;

		while (true)
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

			System.out.println("Computer board");
			for (int j = 0; j < computerBoard.length; j++)
			{
				for (int n = 0; n < computerBoard[j].length; n++)
				{
					if (computerBoard[j][n])
					{
						System.out.print("X ");
					}
					else
					{
						System.out.print("- ");
					}
				}
				System.out.println();
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

			System.out.println("Player board");
			for (int j = 0; j < playerBoard.length; j++)
			{
				for (int n = 0; n < playerBoard[j].length; n++)
				{
					if (playerBoard[j][n])
					{
						System.out.print("X ");
					}
					else
					{
						System.out.print("- ");
					}
				}
				System.out.println();
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

		String winner = doesPlayerHaveShipsLeft ? "Player" : "Computer";

		System.out.printf("%s wins", winner);
	}
}
