package exercices.tp.factory;

import exercices.tp.entity.AbstractProductBuilder;
import exercices.tp.entity.Product;

public class ProductFactory<T extends Product>
{
	public T createProduct(AbstractProductBuilder<T> builder)
	{
		return builder.build();
	}
}
