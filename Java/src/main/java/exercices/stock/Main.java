package exercices.stock;

public class Main
{
	public static void main(String[] args)
	{
		Product product = new Product();
		StockObserver stockObserver = new StockObserver();
		StockSupplier stockSupplier = new StockSupplier();
		StockChangeManager.addListener(stockObserver);
		StockChangeManager.addListener(stockSupplier);

		product.setStockLevel(50);
		product.setStockLevel(9);
	}
}
