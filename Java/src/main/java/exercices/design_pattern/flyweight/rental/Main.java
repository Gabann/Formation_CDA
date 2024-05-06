package exercices.design_pattern.flyweight.rental;

public class Main
{
	public static void main(String[] args)
	{
		FlyWeightFactory factory = new FlyWeightFactory();
		Vehicle vehicle1 = new Vehicle(factory.getFlyweight("Audi", "Black"), "TT");
		Vehicle vehicle2 = new Vehicle(factory.getFlyweight("Audi", "Black"), "ZZ");
	}
}
