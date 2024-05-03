package exercices.stock;

public class StockObserver implements StockChangeListener
{
	int stockCriticalLevel = 10;

	public StockObserver()
	{
		StockChangeManager.addListener(this);
	}

	@Override
	public void onStockChange(Product product)
	{
		if (product.getStockLevel() < stockCriticalLevel)
		{
			System.out.printf("Stock level is critical at %d%n", product.getStockLevel());
		}
	}
}
