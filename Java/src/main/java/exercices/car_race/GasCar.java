package exercices.car_race;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GasCar extends Car
{
	private double maxGasLitter = 2;
	private double currentGasLitter;

	private GasCar(GasCarBuilder gasCarBuilder)
	{
		super(gasCarBuilder.name);
		this.maxGasLitter = gasCarBuilder.maxGasLitter;
		this.currentGasLitter = gasCarBuilder.currentGasLitter;
	}

	public static class GasCarBuilder extends CarBuilder<GasCar>
	{
		double maxGasLitter;
		double currentGasLitter;

		public GasCarBuilder maxGasLitter(int maxGasLitter)
		{
			this.maxGasLitter = maxGasLitter;
			return this;
		}

		public GasCarBuilder currentGasLitter(int currentGasLitter)
		{
			this.currentGasLitter = currentGasLitter;
			return this;
		}

		@Override
		public GasCar build()
		{
			return new GasCar(this);
		}
	}
}
