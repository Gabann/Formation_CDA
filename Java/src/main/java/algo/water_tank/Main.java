package algo.water_tank;

public class Main
{
	public static void main(String[] args)
	{
		final String lineSeparator = "----------------------------------------------------------";

		WaterTank waterTank1 = new WaterTank(300, 30, 10);
		WaterTank waterTank2 = new WaterTank(330, 50, 20);

		System.out.printf("Water tank 1 total weight %d %n", waterTank1.getWeight());
		System.out.printf("Water tank 2 total weight %d %n", waterTank2.getWeight());

		System.out.println(lineSeparator);

		System.out.printf("Water tank 1 current water level %d %n", waterTank1.getCurrentCapacityLitter());
		System.out.printf("Water tank 2 current water level %d %n", waterTank2.getCurrentCapacityLitter());
		System.out.printf("Water amount in all water tanks %d %n", WaterTank.getTotalWaterTankCapacityLitter());


		System.out.println(lineSeparator);

		int addAmount = 25;
		int excessiveAmount = waterTank1.addWater(addAmount);
		System.out.printf("Water tank 1 water level after adding %d litters: ", addAmount);
		System.out.printf("%d/%d %n", waterTank1.getCurrentCapacityLitter(), waterTank1.getMaxCapacityLitter());
		System.out.printf("Excessive amount: %d %n", excessiveAmount);

		int removeAmount = 25;
		int amountRemoved = waterTank2.removeWater(removeAmount);
		System.out.printf("Water tank 2 water level after adding %d litters: ", removeAmount);
		System.out.printf("%d/%d %n", waterTank2.getCurrentCapacityLitter(), waterTank2.getMaxCapacityLitter());
		System.out.printf("You got : %d litters %n", amountRemoved);

		System.out.println(lineSeparator);

		System.out.printf("Water tank 1 current water level %d %n", waterTank1.getCurrentCapacityLitter());
		System.out.printf("Water tank 2 current water level %d %n", waterTank2.getCurrentCapacityLitter());
		System.out.printf("Water amount in all water tanks %d %n", WaterTank.getTotalWaterTankCapacityLitter());
	}
}
