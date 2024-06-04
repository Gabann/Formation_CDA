package tdd.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrieVielliTest
{
	@Test
	void brieVielliQualityShouldIncreaseInsteadOfDecreaseOverTime()
	{
		BrieVielli brieVielli = new BrieVielli();

		brieVielli.setQuality(10);
		brieVielli.update();
		assertEquals(11, brieVielli.getQuality());
	}
}
