package algo.stationery;

public class Pen extends Article
{
	String color;

	public Pen(double price, String name, String color)
	{
		super(price, name);
		this.color = color;
	}
}
