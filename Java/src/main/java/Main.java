import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Input temperature in celsius");
		float celsiusTemp = input.nextFloat();
		float convertedCelsiusTemp = (celsiusTemp * 9 / 5) + 32;

		System.out.println("Converted temperature to fahrenheit: " + convertedCelsiusTemp);

		System.out.println("Input temperature in fahrenheit");
		float fahrenheitTemp = input.nextFloat();
		float convertedFahrenheitTemp = (fahrenheitTemp - 32) * 5 / 9;
		System.out.println("Converted temperature to celsius: " + convertedCelsiusTemp);
		System.out.println(convertedFahrenheitTemp);

		System.out.println("Input candy price");
		float candyPrice = input.nextFloat();
		System.out.println("Input candy quantity");
		int candyCount = input.nextInt();

		System.out.println("Total price: " + candyCount * candyPrice);

		System.out.println("First input");
		input.next();
		LocalDateTime timeAfterFirstInput = LocalDateTime.now();

		System.out.println("Second input");
		input.next();

		System.out.println(Duration.between(timeAfterFirstInput, LocalDateTime.now()).getSeconds() + " seconds between inputs");
	}

//	static float celsiusToFahrenheit(float celsiusTemp)
//	{
//		return (celsiusTemp * 9 / 5) + 32;
//	}
//
//	static float fahrenheitToCelsius(float fahrenheitTemp)
//	{
//		return (fahrenheitTemp - 32) * 5 / 9;
//	}
}
