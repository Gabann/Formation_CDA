package algo.figure;

public class Square extends Figure
{
	double length;

	public Square(double length)
	{
		this.length = length;
	}

	@Override
	public String toString()
	{
		return "Coords of ABCD{" + "\n" +
				"A: " + origin.posX + ";" + origin.posY + "\n" +
				"B: " + (origin.posX + length) + ";" + origin.posY + "\n" +
				"C: " + (origin.posX + length) + ";" + (origin.posY + length) + "\n" +
				"D: " + origin.posX + ";" + (origin.posY + length) + "\n" +
				'}';
	}
}
