package tdd;

public class DiceScore
{
	public static int getScore(Dice dice)
	{
		int scoreFirst = dice.getRoll();
		int scoreSecond = dice.getRoll();

		if (scoreFirst == scoreSecond)
		{
			if (scoreFirst == 6)
			{
				return 30;
			}
			return scoreFirst * 2 + 10;
		}
		else
		{
			return scoreFirst < scoreSecond ? scoreSecond : scoreFirst;
		}
	}
}
