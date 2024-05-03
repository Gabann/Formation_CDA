package exercices.car_race;

public abstract class CarBuilder<T extends Car>
{
	String name;

	public CarBuilder<T> name(String name)
	{
		this.name = name;
		return this;
	}

	public abstract T build();
}
