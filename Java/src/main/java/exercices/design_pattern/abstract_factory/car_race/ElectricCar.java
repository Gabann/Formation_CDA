package exercices.design_pattern.abstract_factory.car_race;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ElectricCar extends Car
{
	private int maxMilliampere;
	private int currentMilliampere;

	private ElectricCar(ElectricCarBuilder electricCarBuilder)
	{
		super(electricCarBuilder.name);
		this.maxMilliampere = electricCarBuilder.maxMilliampere;
		this.currentMilliampere = electricCarBuilder.currentMilliampere;
	}

	public static class ElectricCarBuilder extends CarBuilder<ElectricCar>
	{
		int maxMilliampere;
		int currentMilliampere;

		public ElectricCarBuilder maxMilliampere(int maxMilliampere)
		{
			this.maxMilliampere = maxMilliampere;
			return this;
		}

		public ElectricCarBuilder currentMilliampere(int currentMilliampere)
		{
			this.currentMilliampere = currentMilliampere;
			return this;
		}

		@Override
		public ElectricCar build()
		{
			return new ElectricCar(this);
		}
	}
}
