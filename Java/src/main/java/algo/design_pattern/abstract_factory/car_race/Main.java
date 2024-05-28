package algo.design_pattern.abstract_factory.car_race;

public class Main
{
	public static void main(String[] args)
	{
		var electricCar =
				new CarFactory<ElectricCar>()
						.createCar(new ElectricCar.ElectricCarBuilder()
								.currentMilliampere(100)
								.maxMilliampere(200)
								.name("Car1"));

		var electricCar2 =
				new CarFactory<ElectricCar>()
						.createCar(new ElectricCar.ElectricCarBuilder()
								.currentMilliampere(100)
								.maxMilliampere(200)
								.name("Car2"));

		var gasCar =
				new CarFactory<GasCar>()
						.createCar(new GasCar.GasCarBuilder()
								.currentGasLitter(100)
								.maxGasLitter(200)
								.name("Car3"));

		var gasCar2 =
				new CarFactory<GasCar>()
						.createCar(new GasCar.GasCarBuilder()
								.currentGasLitter(100)
								.maxGasLitter(200)
								.name("Car4"));

		System.out.println(electricCar.getName());

		RaceManager.getInstance().addCar(electricCar);
		RaceManager.getInstance().addCar(electricCar2);
		RaceManager.getInstance().addCar(gasCar);
		RaceManager.getInstance().addCar(gasCar2);
		RacePositionChangedEvent.addListener(RaceManager.getInstance());

		System.out.println(RaceManager.getInstance().getRacePositions());

		RaceManager.getInstance().updateCarPosition(electricCar, 4);

		System.out.println(RaceManager.getInstance().getRacePositions());
	}
}
