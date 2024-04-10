package exercices;

enum TemperatureUnit
{
	KELVIN,
	CELSIUS,
	FAHRENHEIT
}

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
			case CELSIUS -> this.temperatureKelvin = temperature + 273.15;
			case FAHRENHEIT -> this.temperatureKelvin = (temperature - 32) * 5 / 9 + 273.15;
		}
	}

	public double getTemperatureKelvin()
	{
		return temperatureKelvin;
	}

	private void setTemperatureKelvin(double temperatureCelsius)
	{
		this.temperatureKelvin = temperatureCelsius + 273.15;
	}

	public double getTemperatureCelsius()
	{
		return temperatureKelvin - 273.15;
	}

	private void setTemperatureCelsius(double temperatureKelvin)
	{
		this.temperatureKelvin = temperatureKelvin;
	}

	public double getTemperatureFahrenheit()
	{
		return (temperatureKelvin - 273.15) * 9.0 / 5 + 32.0;
	}

	private void setTemperatureFahrenheit(double temperatureFahrenheit)
	{
		this.temperatureKelvin = (temperatureFahrenheit - 32) * 5 / 9 + 273.15;
	}
}
