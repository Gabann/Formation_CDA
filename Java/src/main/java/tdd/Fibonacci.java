package tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fibonacci
{
	private Fibonacci()
	{
	}

	public static List<Integer> getFibSeries(int range)
	{
		if (range < 0)
		{
			throw new NegativeInputException();
		}

		if (range == 0)
		{
			return Collections.emptyList();
		}

		List<Integer> result = new ArrayList<>();
		int a = 0, b = 1, c = 0;
		if (range == 1)
		{
			result.add(0);
			return result;
		}
		result.add(0);
		result.add(1);
		for (int i = 2; i < range; i++)
		{
			c = a + b;
			result.add(c);
			a = b;
			b = c;
		}
		return result;
	}

	public static class NegativeInputException extends RuntimeException
	{
		public NegativeInputException()
		{
			super("Negative input");
		}
	}
}
