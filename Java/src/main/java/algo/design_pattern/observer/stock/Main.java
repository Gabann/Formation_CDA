package algo.design_pattern.observer.stock;

public class Main
{
	public static void main(String[] args)
	{
		Product product = new Product();
		StockSupplier stockSupplier = new StockSupplier();

		product.setStockLevel(50);
		StockChangeManager.removeListener(stockSupplier);
		product.setStockLevel(9);
	}
}
