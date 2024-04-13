package exercices.figure;

public class Main
{
	public static void main(String[] args)
	{
		var square = new Square(2);

		System.out.println(square);

		var rectangle = new Rectangle(4, 2);

		System.out.println(rectangle);

		var triangle = new Triangle(3, 5);

		System.out.println(triangle);

		triangle.move(2, 3);

		System.out.println(triangle);
	}
}
