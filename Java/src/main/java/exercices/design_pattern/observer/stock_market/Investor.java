package exercices.design_pattern.observer.stock_market;

import lombok.Builder;

@Builder
public class Investor implements MarketShareListener
{
	String name;

	@Override
	public void onMarketShareValueChange(MarketShare marketShare)
	{
		System.out.printf("%s saw the change of %s value changed to %.2f%n", this.name, marketShare.getName(),
				marketShare.getPrice());
	}
}
