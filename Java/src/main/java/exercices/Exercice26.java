package exercices;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercice26
{
	static boolean isAdnValid(String adn)
	{
		String regex = "^[atcg]*$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(adn);

		if (!matcher.matches())
		{
			System.out.println("Please input valid adn (should only contains a,t,c and g");
		}

		return matcher.matches();
	}

	static String inputAdn()
	{
		Scanner scanner = new Scanner(System.in);
		String input;

		do
		{
			System.out.println("Enter your adn sequence");

			input = scanner.next().toLowerCase();
		}
		while (!isAdnValid(input));

		return input;
	}

	static double getAdnProportionPercentage(String inputAdn, String adnSequence)
	{
		adnSequence = adnSequence.toLowerCase();

		if (!inputAdn.contains(adnSequence))
		{
			return 0;
		}

		double percentage = 0;

		for (int i = 0; i < inputAdn.length(); )
		{
			String subString = inputAdn.substring(i, adnSequence.length() + i);

			if (subString.equals(adnSequence))
			{
				percentage += (double) adnSequence.length() / inputAdn.length();
				i += adnSequence.length();
			}
			else
			{
				i++;
			}
		}

		return percentage;
	}

	public static void run()
	{
		String adn = inputAdn();

		System.out.println(getAdnProportionPercentage(adn, "ac"));
	}
}
