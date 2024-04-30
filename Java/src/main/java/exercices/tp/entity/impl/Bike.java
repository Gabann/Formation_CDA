package exercices.tp.entity.impl;

import exercices.tp.entity.AbstractProductBuilder;
import exercices.tp.entity.Product;

public class Bike extends Product
{
	String brand;
	int wheelSizeCentimeter;

	private Bike(BikeBuilder bikeBuilder)
	{
		super(bikeBuilder);
		this.brand = bikeBuilder.brand;
		this.wheelSizeCentimeter = bikeBuilder.wheelSizeCentimeter;
	}

	@Override
	public String toString()
	{
		return "Bike{" +
				"brand='" + brand + '\'' +
				", wheelSizeCentimeter=" + wheelSizeCentimeter +
				"} " + super.toString();
	}

	public static class BikeBuilder extends AbstractProductBuilder<Bike>
	{
		String brand;
		int wheelSizeCentimeter;

		public BikeBuilder brand(String brand)
		{
			this.brand = brand;
			return this;
		}

		public BikeBuilder wheelSize(int wheelSize)
		{
			this.wheelSizeCentimeter = wheelSize;
			return this;
		}

		@Override
		public Bike build()
		{
			return new Bike(this);
		}
	}
}
