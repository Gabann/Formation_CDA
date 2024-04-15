package exercices.fizzbuzz;


public class Main
{
	static final int STARTING_INDEX = -50;
	static final int MAX_INDEX = 333;
	static Rule[] ruleset = {
			new Rule(3, "Fizz"),
			new Rule(5, "Buzz"),
			new Rule(7, "Bizz"),
			new Rule(34, "Fuzz")
	};

	public static void main(String[] args)
	{
		for (int i = STARTING_INDEX; i <= MAX_INDEX; i++)
		{
			StringBuilder result = new StringBuilder();

			for (Rule rule : ruleset)
			{
				if (i % rule.number == 0)
				{
					result.append(rule.text);
				}
			}

			System.out.printf("%d: %s %n", i, result);
		}
	}

	private static class Rule
	{
		int number;
		String text;

		public Rule(int number, String text)
		{
			this.number = number;
			this.text = text;
		}
	}
}
