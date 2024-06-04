package tdd.shop;


import java.util.List;

public class Shop
{
	List<Product> productList;

	void updateAllProducts()
	{
		for (Product product : productList)
		{
			product.update();
		}
	}
}
