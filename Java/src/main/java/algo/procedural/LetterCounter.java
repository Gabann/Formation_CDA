package algo.procedural;

public class LetterCounter
{
	static int countLetterA(String input)
	{
		int count = 0;
		input = input.toLowerCase();

		for (int i = 0; i < input.length(); i++)
		{
			if (input.charAt(i) == 'a')
			{
				count++;
			}
		}

		return count;
	}

	static int countLetterANoLoop(String input)
	{
		return (int) input.chars().filter(letter -> letter == 'a').count();
	}

	public static void main(String[] args)
	{
		System.out.println(countLetterA("C'est le b-a ba"));
		System.out.println(countLetterA("mixer"));

		System.out.println(countLetterANoLoop("C'est le b-a ba"));
		System.out.println(countLetterANoLoop("mixer"));
	}
}
