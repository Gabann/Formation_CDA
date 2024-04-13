package exercices.procedural;

import java.util.Scanner;

public class CharTriangle
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter triangle size");
		int triangleSize = scanner.nextInt();

		System.out.println("Enter triangle character");
		char triangleCharacter = scanner.next().charAt(0);

		for (int i = 0; i < triangleSize; i++)
		{

			String line = " ".repeat(triangleSize - i) +
					String.valueOf(triangleCharacter).repeat(Math.max(0, 1 + 2 * i));

			System.out.println(line);
		}
	}
}
