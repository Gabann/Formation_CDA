package org.example.ex_02.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.ex_02.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class CarService
{
	public static List<Car> carList = new ArrayList<>(
			Arrays.asList(
					new Car("BMW", 2015, "black"),
					new Car("Audi", 2016, "white"),
					new Car("Mercedes", 2017, "red")));

	public Car save(String brand, int creationYear, String color)
	{
		return new Car(brand, creationYear, color);
	}
}
