package exercices;

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

	private void setName(String name)
	{
		this.name = name;
	}

	private double getHeightCentimeter()
	{
		return heightCentimeter;
	}

	private void setHeightCentimeter(double heightCentimeter)
	{
		this.heightCentimeter = heightCentimeter;
	}

	private String getColor()
	{
		return color;
	}

	private void setColor(String color)
	{
		this.color = color;
	}

	@Override
	public String toString()
	{
		return String.format("Class: %s%n" +
						"Name: %s%n" +
						"Height: %.2f%n" +
						"Color: %s%n"
				, this.getClass().getName(), getName(), getHeightCentimeter(), getColor());
	}
}
