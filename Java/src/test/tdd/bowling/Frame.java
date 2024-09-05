package tdd.bowling;


import org.hibernate.cfg.NotYetImplementedException;

import java.util.List;

public class Frame
{
	public int currentRound;
	public int currentThrow;
	public List<Integer[]> throwHistory;

	public int throwBall()
	{
		throw new NotYetImplementedException();
	}
}
