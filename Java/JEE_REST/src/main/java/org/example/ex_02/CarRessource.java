package org.example.ex_02;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.ex_02.services.CarService;

import java.util.List;

@Path("/carsRessource")
public class CarRessource
{
	private final CarService carService;

	@Inject
	public CarRessource(CarService carService)
	{
		this.carService = carService;
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getAllCar()
	{
		return CarService.carList;
	}

	@POST
	@Path("/deleteById")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCarById(@QueryParam("id") Long id)
	{
		CarService.carList.removeIf(car -> car.getId().equals(id));
	}

	@POST
	@Path("/updateById")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateById(@QueryParam("id") Long id, Car newCar)
	{
		Car oldCar = getById(id);
		int index = CarService.carList.indexOf(oldCar);
		CarService.carList.set(index, new Car(id, newCar));
	}

	@GET
	@Path("/getById")
	@Produces(MediaType.APPLICATION_JSON)
	public Car getById(@QueryParam("id") Long id)
	{
		return CarService.carList.stream()
				.filter(car -> car.getId().equals(id))
				.findFirst()
				.orElse(null);
	}

	@POST
	@Path("/createCar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createCar(Car car)
	{
		CarService.carList.add(new Car(car));
	}
}
