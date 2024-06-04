package tdd.shop;

public class DairyProduct extends Product
{
	@Override
	public void update()
	{
		setQuality(this.getQuality() - 2);
	}
}
