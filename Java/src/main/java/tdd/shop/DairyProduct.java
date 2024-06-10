package tdd.shop;

public class DairyProduct extends Product
{
	@Override
	public void updateQuality()
	{
		incrementQuality(-2);
	}
}
