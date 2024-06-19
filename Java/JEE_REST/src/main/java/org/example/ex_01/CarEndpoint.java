package org.example.ex_01;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.ArrayList;
import java.util.List;

@Path("/cars")
public class CarEndpoint
{
	List<Car> carList = new ArrayList<>();

	@GET
	@Produces("application/json")
	public List<Car> getCars()
	{
		carList.add(new Car("BMW", 2015, "black"));
		carList.add(new Car("Audi", 2016, "white"));
		carList.add(new Car("Mercedes", 2017, "red"));
		return carList;
	}

	@GET
	@Path("/one")
	@Produces("application/json")
	public Car getOneCar()
	{
		Car car = new Car("BMW", 2015, "black");
		return car;
	}
}
