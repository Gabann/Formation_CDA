package com.example.service;

import com.example.entity.Order;
import com.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService
{
	private final OrderRepository repository;

	public OrderService(OrderRepository repository)
	{
		this.repository = repository;
	}

	public List<Order> getAll()
	{
		return repository.findAll();
	}
}
