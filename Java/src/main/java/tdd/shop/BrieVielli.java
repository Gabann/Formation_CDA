package tdd.shop;

public class BrieVielli extends Product
{
	@Override
	public void update()
	{
		setQuality(this.getQuality() + 1);
	}
}
