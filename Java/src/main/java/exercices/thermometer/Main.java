package exercices.thermometer;


public class Main
{
	public static void main(String[] args)
	{
		Thermometer thermometer1 = new Thermometer(20, Thermometer.TemperatureUnit.CELSIUS);
		Thermometer thermometer2 = new Thermometer(293.15, Thermometer.TemperatureUnit.KELVIN);
		Thermometer thermometer3 = new Thermometer(67.73, Thermometer.TemperatureUnit.FAHRENHEIT);

		System.out.println(thermometer1.getTemperatureFahrenheit());
		System.out.println(thermometer2.getTemperatureCelsius());
		System.out.println(thermometer3.getTemperatureKelvin());
	}
}
