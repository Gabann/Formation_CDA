package algo.design_pattern.flyweight.rental;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightFactory
{
	private final Map<String, SharedVehicleState> flyweights = new HashMap<>();

	public SharedVehicleState getFlyweight(String brand, String color)
	{
		String key = brand + "|" + color;
		if (!flyweights.containsKey(key))
		{
			flyweights.put(key, new SharedVehicleState(brand, color));
		}
		return flyweights.get(key);
	}
}
