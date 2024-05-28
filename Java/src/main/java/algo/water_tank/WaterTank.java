package algo.water_tank;

public class WaterTank
{
	private static int totalWaterTankCapacityLitter;
	private final int emptyWeightKg;
	private final int maxCapacityLitter;
	private int currentCapacityLitter;

	public WaterTank(int emptyWeightKg, int maxCapacityLitter, int currentCapacityLitter)
	{
		this.emptyWeightKg = emptyWeightKg;
		this.maxCapacityLitter = maxCapacityLitter;
		setCurrentCapacityLitter(currentCapacityLitter);
	}

	public static int getTotalWaterTankCapacityLitter()
	{
		return totalWaterTankCapacityLitter;
	}

	public static void setTotalWaterTankCapacityLitter(int totalWaterTankCapacityLitter)
	{
		WaterTank.totalWaterTankCapacityLitter = totalWaterTankCapacityLitter;
	}

	public int getMaxCapacityLitter()
	{
		return maxCapacityLitter;
	}

	public int getCurrentCapacityLitter()
	{
		return currentCapacityLitter;
	}

	private void setCurrentCapacityLitter(int currentCapacityLitter)
	{
		int previousAmount = this.currentCapacityLitter;

		this.currentCapacityLitter = Math.max(0, Math.min(maxCapacityLitter, currentCapacityLitter));

		setTotalWaterTankCapacityLitter(getTotalWaterTankCapacityLitter() - previousAmount + this.currentCapacityLitter);
	}

	int addWater(int amountLitter)
	{
		int overflowAmount = maxCapacityLitter - (amountLitter - currentCapacityLitter);

		setCurrentCapacityLitter(currentCapacityLitter + amountLitter);

		return Math.max(overflowAmount, 0);
	}

	int removeWater(int amountLitter)
	{
		int previousCapacity = currentCapacityLitter;

		setCurrentCapacityLitter(currentCapacityLitter - amountLitter);

		return previousCapacity - currentCapacityLitter;
	}

	int getWeight()
	{
		return emptyWeightKg + currentCapacityLitter;
	}
}
