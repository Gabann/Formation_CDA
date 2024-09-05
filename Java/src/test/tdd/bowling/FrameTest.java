package test.tdd.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FrameTest
{
	private Frame frame;

	@BeforeEach
	void init()
	{
		frame = new Frame();
	}

	@Test
	void roundShouldIncrementOnFirstThrowOnStrike()
	{
		if (frame.currentRound != 10)
		{
			Mockito.when(test.tdd.bowling.Rng.getRng()).thenReturn(10);
			frame.throwBall();

			assertEquals(2, frame.currentRound);
		}
	}

	@Test
	void throwsShouldAppearInThrowHistory()
	{
		Mockito.when(test.tdd.bowling.Rng.getRng()).thenReturn(10);
		frame.throwBall();

		assertEquals(frame.throwHistory, List.of(new Integer[]{10}));

		Mockito.when(test.tdd.bowling.Rng.getRng()).thenReturn(3, 7);
		frame.throwBall();
		assertEquals(frame.throwHistory, List.of(new Integer[]{10}, new Integer[]{3, 7}));
	}

	@Test
	void shouldNotHitMoreThan10Quills()
	{
		Mockito.when(test.tdd.bowling.Rng.getRng()).thenReturn(5, 6);
		frame.throwBall();

		assertThrows(RuntimeException.class, () -> frame.throwBall());
	}

	@Test
	void lastRoundShouldAllow2ThrowsIfStrike()
	{
		frame.currentRound = 10;
		Mockito.when(test.tdd.bowling.Rng.getRng()).thenReturn(10);
		frame.throwBall();

		frame.throwBall();

		assertEquals(frame.throwHistory.get(10), new Integer[]{10, 10});
	}
}
