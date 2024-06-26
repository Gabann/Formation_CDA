package algo.design_pattern.adapter.refactoring_guru;

/**
 * SquarePegs are not compatible with RoundHoles (they were implemented by
 * previous development team). But we have to integrate them into our program.
 */
public class SquarePeg
{
	private final double width;

	public SquarePeg(double width)
	{
		this.width = width;
	}

	public double getWidth()
	{
		return width;
	}

	public double getSquare()
	{
		double result;
		result = Math.pow(this.width, 2);
		return result;
	}
}
