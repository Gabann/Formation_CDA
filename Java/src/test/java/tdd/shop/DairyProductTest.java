package tdd.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DairyProductTest
{

	@Test
	void dairyProductShouldDegradeTwiceAsFast()
	{
		DairyProduct dairyProduct = new DairyProduct();

		dairyProduct.setQuality(10);
		dairyProduct.update();
		assertEquals(8, dairyProduct.getQuality());
	}
}
