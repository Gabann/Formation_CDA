package cda.tporderservice.controller;

import cda.tporderservice.entity.Order;
import cda.tporderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Order>> getAllOrders()
	{
		List<Order> orders = service.getAll();
		return ResponseEntity.ok(orders);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long id)
	{
		Order order = service.getById(id);
		if (order == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(order);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addOrder(@RequestBody Order order)
	{
		return service.create(order);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteOrder(@PathVariable Long id)
	{
		boolean deleted = service.deleteById(id);
		if (!deleted)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
		}
		return ResponseEntity.ok(true);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Boolean> updateOrder(@PathVariable Long id, @RequestBody Order order)
	{
		boolean updated = service.updateById(id, order);
		if (!updated)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
		}
		return ResponseEntity.ok(true);
	}
}
