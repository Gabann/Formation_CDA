package exercices.figure;

public class Triangle extends exercices.figure.Figure
{
	double base;
	double height;

	public Triangle(double base, double height)
	{
		this.base = base;
		this.height = height;
	}

	@Override
	public String toString()
	{
		return "Coords of ABC{" + "\n" +
				"A: " + (origin.posX - base / 2) + ";" + origin.posY + "\n" +
				"B: " + (origin.posX + base / 2) + ";" + origin.posY + "\n" +
				"C: " + origin.posX + ";" + (origin.posY + height) + "\n" +
				'}';
	}
}
