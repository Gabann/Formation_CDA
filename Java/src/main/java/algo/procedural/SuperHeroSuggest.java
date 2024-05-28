package algo.procedural;

import java.util.Scanner;

public class SuperHeroSuggest
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("What's your favorite thing between 'strength', 'speed' and 'intelligence'");

		switch (input.next().toLowerCase())
		{
			case "strength":
			{
				System.out.println("Hulk");
				break;
			}
			case "speed":
			{
				System.out.println("Flash");
				break;
			}
			case "intelligence":
			{
				System.out.println("Iron man");
				break;
			}
			default:
			{
				System.out.println("Wrong input");
			}
		}
	}
}
