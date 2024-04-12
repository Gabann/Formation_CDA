package exercices;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TimeBetweenInputs
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("First input");
		input.next();
		LocalDateTime timeAfterFirstInput = LocalDateTime.now();

		System.out.println("Second input");
		input.next();

		System.out.println(Duration.between(timeAfterFirstInput, LocalDateTime.now()).getSeconds() + " seconds between inputs");
	}
}
