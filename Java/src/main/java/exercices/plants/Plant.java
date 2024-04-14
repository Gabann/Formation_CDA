package exercices.plants;

public class Plant
{
	String name;
	double heightCentimeter;
	String color;

	protected Plant(String name, double heightCentimeter, String color)
	{
		this.name = name;
		this.heightCentimeter = heightCentimeter;
		this.color = color;
	}

	private String getName()
	{
		return name;
	}

	private double getHeightCentimeter()
	{
		return heightCentimeter;
	}

	private String getColor()
	{
		return color;
	}

	@Override
	public String toString()
	{
		return String.format("Class: %s%n" +
						"Name: %s%n" +
						"Height: %.2f%n" +
						"Color: %s%n"
				, this.getClass().getSimpleName(), getName(), getHeightCentimeter(), getColor());
	}
}
