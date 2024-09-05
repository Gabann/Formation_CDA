package tdd.shop;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class DairyProductTest extends ProductTest
{
	@Override
	protected DairyProduct createProduct()
	{
		return new DairyProduct();
	}

	@Test
	void dairyProductShouldDegradeTwiceAsFast()
	{
		product.setQuality(10);
		product.update();
		assertEquals(8, product.getQuality());

		product.setQuality(10);
		product.daysLeftToSell = -5;
		product.update();
		assertEquals(6, product.getQuality());
	}
}
