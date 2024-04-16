package exercices.stationery;

public class Article extends SoldItem
{
	private final double price;
	private final String name;

	public Article(double price, String name)
	{
		this.price = price;
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public double getPrice()
	{
		return price;
	}
}
