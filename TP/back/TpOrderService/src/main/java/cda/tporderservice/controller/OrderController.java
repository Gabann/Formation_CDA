package cda.tporderservice.controller;

import cda.tporderservice.entity.Order;
import cda.tporderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController
{
	private final OrderService service;

	public OrderController(OrderService service)
	{
		this.service = service;
	}

	@GetMapping("/all")
	public List<Order> getAllOrders()
	{
		return service.getAll();
	}

	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable Long id)
	{
		return service.getById(id);
	}

	@PostMapping("/add")
	public Order addOrder(@RequestBody Order order)
	{
		return service.create(order);
	}

	@DeleteMapping("/{id}")
	public boolean deleteOrder(@PathVariable Long id)
	{
		return service.deleteById(id);
	}

	@PutMapping("/{id}")
	public boolean updateOrder(@PathVariable Long id, @RequestBody Order order)
	{
		return service.updateById(id, order);
	}
}
