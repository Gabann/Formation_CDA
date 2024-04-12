package exercices.hangman;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Hangman hangman;

		System.out.println("Do you want to use default live count? (true, false)");
		boolean useDefaultLiveCount = scanner.nextBoolean();

		if (!useDefaultLiveCount)
		{
			System.out.println("Enter numbers of lives you want to have");
			hangman = new Hangman(scanner.nextInt());
		}
		else
		{
			hangman = new Hangman();
		}

		System.out.println(hangman.generateMask());

		while (!hangman.checkWinStatus() && hangman.tryCount > 0)
		{
			hangman.tryChar();
		}

		System.out.println(hangman.checkWinStatus() ? "You won" : "You lost");
		System.out.println("The word was " + hangman.secretWord);
	}
}
