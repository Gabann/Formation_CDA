package exercices.tp.entity;

public abstract class AbstractProductBuilder<T extends Product>
{
	protected double price;

	public AbstractProductBuilder<T> price(double price)
	{
		this.price = price;
		return this;
	}

	public abstract T build();
}
