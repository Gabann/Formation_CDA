package algo.design_pattern.observer.stock_market;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main
{
	public static void main(String[] args)
	{
		MarketShare marketShare1 = MarketShare.builder().price(100).name("marketShare1").build();
		MarketShare marketShare2 = MarketShare.builder().price(200).name("marketShare2").build();

		Investor investor1 = Investor.builder().name("Investor1").build();
		Investor investor2 = Investor.builder().name("Investor2").build();


		marketShare1.addListener(investor1);
		marketShare2.addListener(investor1);
		marketShare2.addListener(investor2);

		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
		Random random = new Random();

		scheduleTask(executorService, random, marketShare1);
		scheduleTask(executorService, random, marketShare2);
	}

	private static void scheduleTask(ScheduledExecutorService executorService, Random random, MarketShare marketShare)
	{
		executorService.schedule(() ->
		{
			marketShare.setRandomPrice();
			scheduleTask(executorService, random, marketShare);
		}, random.nextInt(10), TimeUnit.SECONDS);
	}
}
