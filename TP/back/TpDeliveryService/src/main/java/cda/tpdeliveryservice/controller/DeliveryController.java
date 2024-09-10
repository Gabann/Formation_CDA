package cda.tpdeliveryservice.controller;

import cda.tpdeliveryservice.entity.Delivery;
import cda.tpdeliveryservice.service.DeliveryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController
{
	private final DeliveryService service;

	public DeliveryController(DeliveryService service)
	{
		this.service = service;
	}

	@GetMapping("/all")
	public List<Delivery> getAllDeliveries()
	{
		return service.getAll();
	}

	@GetMapping("/{id}")
	public Delivery getDeliveryById(@PathVariable Long id)
	{
		return service.getById(id);
	}

	@PostMapping("/add")
	public Delivery addDelivery(@RequestBody Delivery delivery)
	{
		return service.create(delivery);
	}

	@DeleteMapping("/{id}")
	public boolean deleteDelivery(@PathVariable Long id)
	{
		return service.deleteById(id);
	}

	@PutMapping("/{id}")
	public boolean updateDelivery(@PathVariable Long id, @RequestBody Delivery delivery)
	{
		return service.updateById(id, delivery);
	}
}
