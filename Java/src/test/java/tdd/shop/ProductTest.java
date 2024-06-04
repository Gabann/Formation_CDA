package tdd.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest
{
	Product product;

	@BeforeEach
	void init()
	{
		product = new Product();
	}

	@Test
	void qualityShouldNotBeNegative()
	{
		product.setQuality(-999);
		assertEquals(0, product.getQuality());
	}

	@Test
	void qualityShouldNotBeAbove50()
	{
		product.setQuality(999);
		assertEquals(50, product.getQuality());
	}

	void qualityDegradeTwiceAsFastWhenDaysLeftIsLessThan0()
	{
		product.daysLeftToSell = -1;
		product.setQuality(10);
		product.update();
		assertEquals(8, product.getQuality());
	}
}
