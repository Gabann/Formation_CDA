package exercices.design_pattern.abstract_factory.car_race;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Setter
@Getter
public class RaceManager implements RacePositionListener
{
	private static RaceManager instance;

	private final HashMap<Car, Integer> racePositions = new HashMap<>();

	public static synchronized RaceManager getInstance()
	{
		if (instance == null)
		{
			instance = new RaceManager();
		}

		return instance;
	}

	public void addCar(Car car)
	{
		racePositions.put(car, racePositions.size() + 1);
	}

	public void removeCar(Car car)
	{
		racePositions.put(car, racePositions.size());
	}

	public int getCarPosition(Car car)
	{
		return racePositions.get(car);
	}

	public Car getCarByPosition(int position)
	{
		for (Car car : racePositions.keySet())
		{
			if (racePositions.get(car) == position)
			{
				return car;
			}
		}
		return null;
	}

	void overTake(Car car)
	{
		int oldPosition = getCarPosition(car);
		if (oldPosition == 1)
		{
			return;
		}

		Car carInFront = getCarByPosition(oldPosition - 1);

		racePositions.put(carInFront, oldPosition);
		racePositions.put(car, oldPosition - 1);

		RacePositionChangedEvent.raiseEvent(car, oldPosition - 1);
		RacePositionChangedEvent.raiseEvent(carInFront, oldPosition);
	}

	public void updateCarPosition(Car car, int newPosition)
	{
		int oldPosition = getCarPosition(car);
		if (oldPosition > newPosition)
		{
			for (int i = newPosition; i < oldPosition; i++)
			{
				overTake(car);
			}
		}
		else if (oldPosition < newPosition)
		{
			for (int i = oldPosition; i < newPosition; i++)
			{
				overTake(getCarByPosition(i + 1));
			}
		}
	}

	@Override
	public void onCarPositionChange(Car car, int position)
	{
		System.out.println("Car " + car.getName() + " is now at position " + position);
	}
}
