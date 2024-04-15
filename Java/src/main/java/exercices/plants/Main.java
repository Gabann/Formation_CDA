package exercices.plants;

public class Main
{
	public static void main(String[] args)
	{
		var plant = new Plant("Rose", 30, "Pink");
		System.out.println(plant);

		var tree = new Tree("Oak", 200, "Brown", 50);
		System.out.println(tree);
	}
}
