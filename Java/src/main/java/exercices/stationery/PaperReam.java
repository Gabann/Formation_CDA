package exercices.stationery;

public class PaperReam extends Article
{
	double weightGrams;

	public PaperReam(double price, String name, double weightGrams)
	{
		super(price, name);
		this.weightGrams = weightGrams;
	}
}
