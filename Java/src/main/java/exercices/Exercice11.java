package exercices;

import java.util.Scanner;

public class Exercice11
{
	public static void DrawTriangle()
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter triangle size");
		int triangleSize = scanner.nextInt();

		System.out.println("Enter triangle character");
		char triangleCharacter = scanner.next().charAt(0);

		for (int i = 0; i < triangleSize; i++)
		{
			String line = "";
			line += " ".repeat(triangleSize - i);

			for (int j = 0; j < 1 + 2 * i; j++)
			{
				line += triangleCharacter;
			}

			System.out.println(line);
		}
	}
}
