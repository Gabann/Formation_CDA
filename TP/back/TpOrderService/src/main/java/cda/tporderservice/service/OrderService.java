package cda.tporderservice.service;

import cda.tporderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService
{
	private final OrderRepository repository;

	public OrderService(OrderRepository repository)
	{
		this.repository = repository;
	}
}
