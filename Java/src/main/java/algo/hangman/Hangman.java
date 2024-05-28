package algo.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman
{
	Scanner scanner = new Scanner(System.in);
	int tryCount;
	String secretWord;
	List<Character> triedCharList = new ArrayList<>();


	public Hangman()
	{
		this(10);
	}

	public Hangman(int tryCount)
	{
		this.tryCount = tryCount;
		this.secretWord = RandomWords.getRandomWord().toLowerCase();
	}

	void tryChar()
	{
		if (tryCount <= 0)
		{
			System.out.println("You don't have any lives left");
			return;
		}

		System.out.println("Enter the character you'd like to test");

		char charToTest = scanner.next().toLowerCase().charAt(0);

		if (triedCharList.contains(charToTest))
		{
			System.out.printf("You already tried character %c %n", charToTest);
			return;
		}

		triedCharList.add(charToTest);

		if (!secretWord.contains(String.valueOf(charToTest)))
		{
			System.out.printf("%c does not appear in the secret word %n", charToTest);
			tryCount--;
		}

		printInfo();
	}

	boolean checkWinStatus()
	{
		return generateMask().equals(secretWord);
	}

	String generateMask()
	{
		StringBuilder mask = new StringBuilder();

		for (int i = 0; i < secretWord.length(); i++)
		{
			char currentChar = secretWord.charAt(i);

			if (triedCharList.contains(currentChar))
			{
				mask.append(currentChar);
			}
			else
			{
				mask.append("*");
			}
		}
		return mask.toString();
	}

	void printInfo()
	{
		System.out.printf("You have %d lives left %n", tryCount);
		System.out.printf("You tried letters %s %n", triedCharList);
		System.out.printf("%s %n", generateMask());
	}

}
