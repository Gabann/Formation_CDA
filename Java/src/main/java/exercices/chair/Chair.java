package exercices.chair;

public class Chair
{
	String color;
	int legCount;
	double price;
	String materialType;

	public Chair()
	{
		this("Blue", 4, 20, "Wood");
	}

	public Chair(String color, int legCount, double price, String materialType)
	{
		this.color = color;
		this.legCount = legCount;
		this.price = price;
		this.materialType = materialType;
	}

	public void describeChair()
	{
		System.out.printf("I am a chair with %d legs in %s of color %s and cost %.2f$ %n", this.legCount, this.color, this.materialType,
				this.price);
	}
}
