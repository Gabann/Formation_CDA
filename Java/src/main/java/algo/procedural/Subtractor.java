package algo.procedural;

public class Subtractor
{
	static int subtract(int minuend, int subtrahend)
	{
		System.out.printf("I subtract %d and %d %n", minuend, subtrahend);
		return minuend - subtrahend;
	}

	public static void main(String[] args)
	{
		System.out.println(subtract(5, 3));
		System.out.println(subtract(10, -7));
	}
}
