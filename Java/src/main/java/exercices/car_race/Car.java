package exercices.car_race;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Car
{
	protected String name;

	protected Car(String name)
	{
		this.name = name;
	}
}
