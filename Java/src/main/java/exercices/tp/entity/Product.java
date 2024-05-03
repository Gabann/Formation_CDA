package exercices.tp.entity;

public abstract class Product
{
	protected double price;

	protected Product(AbstractProductBuilder builder)
	{
		this.price = builder.price;
	}

	@Override
	public String toString()
	{
		return "Product{" +
				"price=" + price +
				'}';
	}
}
