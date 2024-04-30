package exercices.stock;

public class Main
{
	public static void main(String[] args)
	{
		Product product = new Product();
		StockObserver stockObserver = new StockObserver();
		StockSupplier stockSupplier = new StockSupplier();

		product.setStockLevel(50);
		StockChangeManager.removeListener(stockSupplier);
		product.setStockLevel(9);
	}
}
