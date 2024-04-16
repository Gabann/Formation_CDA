package exercices.stationery;

public class Ream extends Article
{
	double weightGrams;

	public Ream(double price, String name, double weightGrams)
	{
		super(price, name);
		this.weightGrams = weightGrams;
	}
}
