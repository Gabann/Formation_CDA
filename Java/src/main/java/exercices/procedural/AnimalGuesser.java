package exercices.procedural;

import java.util.Scanner;

public class AnimalGuesser
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		boolean isMammal;
		boolean isLivingUnderwater;

		System.out.println("Is your animal a mammal?");
		isMammal = input.nextBoolean();


		System.out.println("Does your animal lives underwater?");
		isLivingUnderwater = input.nextBoolean();

		if (isMammal)
		{
			if (isLivingUnderwater)
			{
				System.out.println("Your animal could be a dolphin");
			}
			else
			{
				System.out.println("Your animal could be a dog");
			}
		}
		else
		{
			if (isLivingUnderwater)
			{
				System.out.println("Your animal could be a fish");
			}
			else
			{
				System.out.println("Your animal could be a bird");
			}
		}
	}
}
