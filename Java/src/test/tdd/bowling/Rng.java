package test.tdd.bowling;

import java.util.Random;

public final class Rng
{
	public static int getRng()
	{
		return getRng(0, 10);
	}

	public static int getRng(int min, int max)
	{
		Random random = new Random();
		return random.nextInt(min, max);
	}
}
