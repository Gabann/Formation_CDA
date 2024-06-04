package tdd.shop;

public class Product implements ProductInterface
{
	String name;
	String type;
	int maxQuality = 50;
	int minQuality = 0;
	int daysLeftToSell;
	private int quality;

	public int getQuality()
	{
		return quality;
	}

	public void setQuality(int quality)
	{

	}

	@Override
	public void updateProduct()
	{

	}
}
