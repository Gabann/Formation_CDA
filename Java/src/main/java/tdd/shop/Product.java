package tdd.shop;

public class Product implements ProductInterface
{
	String name;
	int maxQuality = 50;
	int minQuality = 0;
	int daysLeftToSell;
	private int quality;

	@Override
	public void update()
	{
		int qualityIncrement = daysLeftToSell < 0 ? -2 : -1;

		this.daysLeftToSell--;
		setQuality(this.getQuality() + qualityIncrement);
	}

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
}
