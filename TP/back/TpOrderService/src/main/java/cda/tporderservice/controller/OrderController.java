package cda.tporderservice.controller;

import cda.tporderservice.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController
{
	private final OrderService service;

	public OrderController(OrderService service)
	{
		this.service = service;
	}
}
