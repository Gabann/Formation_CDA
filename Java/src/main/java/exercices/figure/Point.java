package exercices.figure;

public class Point
{
	double posX;
	double posY;

	public Point()
	{
		this.posX = 0;
		this.posY = 0;
	}

	@Override
	public String toString()
	{
		return "Point{" +
				"posX=" + posX +
				", poxY=" + posY +
				'}';
	}
}
