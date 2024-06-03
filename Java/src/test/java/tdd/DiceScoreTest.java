package tdd;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiceScoreTest
{
	private final Dice dice = Mockito.mock(Dice.class);

	@Test
	void testBothDiceRoll5()
	{
		Mockito.when(dice.getRoll()).thenReturn(5);

		assertEquals(5 * 2 + 10, DiceScore.getScore(dice));
	}

	@Test
	void testBothDiceRoll6()
	{
		Mockito.when(dice.getRoll()).thenReturn(6);

		assertEquals(30, DiceScore.getScore(dice));
	}

	@Test
	void testDice1And6()
	{
		Mockito.when(dice.getRoll()).thenReturn(6, 1);

		assertEquals(6, DiceScore.getScore(dice));
	}

	@Test
	void testDice3And4()
	{
		Mockito.when(dice.getRoll()).thenReturn(3, 4);

		assertEquals(4, DiceScore.getScore(dice));
	}
}
