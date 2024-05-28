package algo.procedural;

import java.util.Scanner;

public class TemperatureConverter
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
		System.out.println("Converted temperature to celsius: " + convertedFahrenheitTemp);
		System.out.println(convertedFahrenheitTemp);
	}
}
