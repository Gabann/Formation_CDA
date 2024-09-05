package com.example.controller;

import com.example.entity.Order;
import com.example.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController
{
	private final OrderService service;

	public OrderController(OrderService service)
	{
		this.service = service;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Order>> getAll()
	{
		return ResponseEntity.ok(service.getAll());
	}
}
