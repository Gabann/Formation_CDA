package algo.design_pattern.observer.stock_market;

public interface MarketShareListener
{
	void onMarketShareValueChange(MarketShare marketShare);
}
