package test.tdd.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HibernateProductTest
{
	protected Product product;

	@BeforeEach
	void init()
	{
		product = createProduct();
	}

	protected Product createProduct()
	{
		return new Product();
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

	@Test
	void productLeftDaysShouldDecrementAfterUpdate()
	{
		product.daysLeftToSell = 5;
		product.update();
		assertEquals(4, product.daysLeftToSell);
	}

	@Test
	void productQualityShouldDecrementTwiceAsFastWhenDaysLeftIsLessThan0()
	{
		product.daysLeftToSell = -1;
		product.setQuality(10);
		product.update();
		assertEquals(8, product.getQuality());
	}
}
