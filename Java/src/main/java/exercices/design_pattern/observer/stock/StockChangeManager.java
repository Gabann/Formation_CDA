package exercices.design_pattern.observer.stock;

import java.util.ArrayList;
import java.util.List;

public final class StockChangeManager
{
	private static final List<StockChangeListener> listeners = new ArrayList<>();

	private StockChangeManager()
	{
	}

	public static void addListener(StockChangeListener listener)
	{
		listeners.add(listener);
	}

	public static void removeListener(StockChangeListener listener)
	{
		listeners.remove(listener);
	}

	public static void raiseEvent(Product product)
	{
		for (StockChangeListener listener : listeners)
		{
			listener.onStockChange(product);
		}
	}
}
