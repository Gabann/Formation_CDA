package exercices.car_race;

public class CarFactory<T extends Car>
{
	public T createCar(CarBuilder<T> builder)
	{
		return builder.build();
	}
}
