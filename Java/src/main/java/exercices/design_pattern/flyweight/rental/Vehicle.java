package exercices.design_pattern.flyweight.rental;

public class Vehicle
{
	private final VehicleFlyWeight vehicleFlyWeight;
	String model;
	
	public Vehicle(VehicleFlyWeight vehicleFlyWeight, String model)
	{
		this.vehicleFlyWeight = vehicleFlyWeight;
		this.model = model;
	}
}
