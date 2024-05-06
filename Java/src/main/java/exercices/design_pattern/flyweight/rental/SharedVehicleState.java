package exercices.design_pattern.flyweight.rental;

public class SharedVehicleState implements VehicleFlyWeight
{
	private final String brand;
	private final String color;

	public SharedVehicleState(String brand, String color)
	{
		this.brand = brand;
		this.color = color;
	}

	@Override
	public void displayInfo(String color, String brand)
	{
		System.out.println(color);
		System.out.println(brand);
	}
}
