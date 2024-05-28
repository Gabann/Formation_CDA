package algo.design_pattern.observer.stock_market;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Builder
@Getter
public class MarketShare
{
	String name;
	double price;
	@Builder.Default
	List<MarketShareListener> marketShareListeners = new ArrayList<>();

	public void raiseEvent()
	{
		for (MarketShareListener listener : marketShareListeners)
		{
			listener.onMarketShareValueChange(this);
		}
	}

	public void addListener(MarketShareListener listener)
	{
		marketShareListeners.add(listener);
	}

	public void removeListener(MarketShareListener listener)
	{
		marketShareListeners.remove(listener);
	}

	private void setPrice(double price)
	{
		this.price = price;
		raiseEvent();
	}

	public void setRandomPrice()
	{
		Random random = new Random();
		setPrice(random.nextDouble(0, Integer.MAX_VALUE));
	}
}
