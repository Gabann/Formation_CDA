package exercices.plants;

public class Tree extends Plant
{
	double circumferenceCentimeter;

	public Tree(String name, double heightCentimeter, String color, double circumferenceCentimeter)
	{
		super(name, heightCentimeter, color);
		this.circumferenceCentimeter = circumferenceCentimeter;
	}

	private double getCircumferenceCentimeter()
	{
		return circumferenceCentimeter;
	}

	@Override
	public String toString()
	{
		return super.toString() + String.format("Tree circumference: %.2f %n"
				, getCircumferenceCentimeter());
	}
}
