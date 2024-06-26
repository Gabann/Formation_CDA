package algo.design_pattern.abstract_factory.tp.factory;

import algo.design_pattern.abstract_factory.tp.entity.AbstractProductBuilder;
import algo.design_pattern.abstract_factory.tp.entity.Product;

public class ProductFactory<T extends Product>
{
	public T createProduct(AbstractProductBuilder<T> builder)
	{
		return builder.build();
	}
}
