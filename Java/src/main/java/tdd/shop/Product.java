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
		this.quality = quality;
		if (this.quality < minQuality)
		{
			this.quality = minQuality;
		}
		else if (this.quality > maxQuality)
		{
			this.quality = maxQuality;
		}
	}

	@Override
	public void updateProduct()
	{
		this.daysLeftToSell--;
		this.quality--;

		if (this.type.equalsIgnoreCase("dairy"))
		{
			this.quality--;
		}
	}
}
