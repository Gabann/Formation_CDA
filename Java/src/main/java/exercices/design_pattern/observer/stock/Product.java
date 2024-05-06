package exercices.design_pattern.observer.stock;

import lombok.Getter;

@Getter
public class Product
{
	private int stockLevel = 100;

	public void setStockLevel(int stockLevel)
	{
		this.stockLevel = stockLevel;
		StockChangeManager.raiseEvent(this);
	}
}
