package exercices;


public class Exercice33
{
	public static void thermometerIhm()
	{
		Thermometer thermometer1 = new Thermometer(20, TemperatureUnit.CELSIUS);
		Thermometer thermometer2 = new Thermometer(293.15, TemperatureUnit.KELVIN);
		Thermometer thermometer3 = new Thermometer(67.73, TemperatureUnit.FAHRENHEIT);

		System.out.println(thermometer1.getTemperatureFahrenheit());
		System.out.println(thermometer2.getTemperatureCelsius());
		System.out.println(thermometer3.getTemperatureKelvin());
	}
}
