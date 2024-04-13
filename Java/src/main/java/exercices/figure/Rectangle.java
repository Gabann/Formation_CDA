package exercices.figure;


public class Rectangle extends Figure
{
	double length;
	double width;

	public Rectangle(double length, double width)
	{
		this.length = length;
		this.width = width;
	}

	@Override
	public String toString()
	{
		return "Coords of ABCD{" + "\n" +
				"A: " + origin.posX + ";" + origin.posY + "\n" +
				"B: " + (origin.posX + length) + ";" + origin.posY + "\n" +
				"C: " + (origin.posX + length) + ";" + (origin.posY + width) + "\n" +
				"D: " + origin.posX + ";" + (origin.posY + width) + "\n" +
				'}';
	}
}
