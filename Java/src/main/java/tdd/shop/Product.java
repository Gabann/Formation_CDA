package tdd.shop;

public class Product implements ProductInterface
{
	private static final int MAX_QUALITY = 50;
	private static final int MIN_QUALITY = 0;
	String name;
	int daysLeftToSell;
	private int quality;

	@Override
	public void update()
	{
		updateQuality();
		updateDaysLeft();
	}

	void updateQuality()
	{
		incrementQuality(-1);
	}

	void updateDaysLeft()
	{
		this.daysLeftToSell--;
	}

	public void incrementQuality(int incrementValue)
	{
		if (daysLeftToSell < 0)
		{
			incrementValue *= 2;
		}

		setQuality(getQuality() + incrementValue);
	}

	public int getQuality()
	{
		return quality;
	}

	public void setQuality(int quality)
	{
		if (quality < MIN_QUALITY)
		{
			quality = MIN_QUALITY;
		}
		else if (quality > MAX_QUALITY)
		{
			quality = MAX_QUALITY;
		}

		this.quality = quality;
	}
}
