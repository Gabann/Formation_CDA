package algo.figure;

public abstract class Figure
{
	Point origin;

	protected Figure()
	{
		this.origin = new Point();
	}

	public void move(double xDirection, double yDirection)
	{
		this.origin.posX += xDirection;
		this.origin.posY += yDirection;
	}
}
