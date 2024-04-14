package exercices.thermometer;

public class Thermometer
{
	private double temperatureKelvin;

	public Thermometer(double temperature, TemperatureUnit temperatureUnit)
	{
		setTemperature(temperature, temperatureUnit);
	}

	private void setTemperature(double temperature, TemperatureUnit temperatureUnit)
	{
		switch (temperatureUnit)
		{
			case KELVIN -> this.temperatureKelvin = temperature;
			case CELSIUS -> setTemperatureCelsius(temperature);
			case FAHRENHEIT -> setTemperatureFahrenheit(temperature);
		}
	}

	public double getTemperatureKelvin()
	{
		return temperatureKelvin;
	}

	public double getTemperatureCelsius()
	{
		return temperatureKelvin - 273.15;
	}

	private void setTemperatureCelsius(double temperatureCelsius)
	{
		this.temperatureKelvin = temperatureCelsius + 273.15;
	}

	public double getTemperatureFahrenheit()
	{
		return getTemperatureCelsius() * 9.0 / 5 + 32.0;
	}

	private void setTemperatureFahrenheit(double temperatureFahrenheit)
	{
		this.temperatureKelvin = (temperatureFahrenheit - 32) * 5 / 9 + 273.15;
	}

	public enum TemperatureUnit
	{
		KELVIN,
		CELSIUS,
		FAHRENHEIT
	}
}
