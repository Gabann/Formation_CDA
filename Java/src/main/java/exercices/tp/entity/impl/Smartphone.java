package exercices.tp.entity.impl;

import exercices.tp.entity.AbstractProductBuilder;
import exercices.tp.entity.Product;

public class Smartphone extends Product
{
	String brand;
	String model;

	private Smartphone(SmartphoneBuilder smartphoneBuilder)
	{
		super(smartphoneBuilder);
		this.brand = smartphoneBuilder.brand;
		this.model = smartphoneBuilder.model;
	}

	@Override
	public String toString()
	{
		return "Smartphone{" +
				"brand='" + brand + '\'' +
				", model='" + model + '\'' +
				"} " + super.toString();
	}

	public static class SmartphoneBuilder extends AbstractProductBuilder<Smartphone>
	{
		private String brand;
		private String model;

		public SmartphoneBuilder brand(String brand)
		{
			this.brand = brand;
			return this;
		}

		public SmartphoneBuilder model(String model)
		{
			this.model = model;
			return this;
		}

		public Smartphone build()
		{
			return new Smartphone(this);
		}
	}
}
