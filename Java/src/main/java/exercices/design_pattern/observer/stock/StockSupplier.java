package exercices.design_pattern.observer.stock;

public class StockSupplier implements StockChangeListener
{
	public StockSupplier()
	{
		StockChangeManager.addListener(this);
	}

	@Override
	public void onStockChange(Product product)
	{
		System.out.printf("%s saw the stock level change to %d%n", this.getClass().getSimpleName(), product.getStockLevel());
	}
}
