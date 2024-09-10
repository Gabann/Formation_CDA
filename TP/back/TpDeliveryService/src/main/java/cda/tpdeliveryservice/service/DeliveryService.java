package cda.tpdeliveryservice.service;

import cda.tpdeliveryservice.dto.OrderDto;
import cda.tpdeliveryservice.entity.Delivery;
import cda.tpdeliveryservice.repository.DeliveryRepository;
import cda.tpdeliveryservice.rest_client.OrderServiceClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DeliveryService
{
	private final DeliveryRepository repository;
	private final OrderServiceClient orderServiceClient;

	public DeliveryService(DeliveryRepository repository, OrderServiceClient orderServiceClient)
	{
		this.repository = repository;
		this.orderServiceClient = orderServiceClient;
	}

	public Delivery getById(Long id)
	{
		Delivery order = repository.findById(id).orElse(null);
		return enrichWithDto(order);
	}

	private Delivery enrichWithDto(Delivery order)
	{
		if (order == null)
		{
			return null;
		}

		OrderDto orderDto = orderServiceClient.getOrderById(order.getId());

		if (orderDto == null)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found for ID " + order.getOrderId());
		}

		order.setOrderDto(orderDto);

		return order;
	}

	public Delivery create(Delivery order)
	{
		return repository.save(order);
	}

	public List<Delivery> getAll()
	{
		List<Delivery> orders = repository.findAll();

		for (Delivery order : orders)
		{
			enrichWithDto(order);
		}

		return orders;
	}

	public boolean deleteById(Long id)
	{
		if (repository.findById(id).isPresent())
		{
			repository.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean updateById(Long id, Delivery newOrder)
	{
		Delivery existingOrder = repository.findById(id).orElse(null);
		if (existingOrder == null)
		{
			return false;
		}
		else
		{
			newOrder.setId(id);
			repository.save(newOrder);
			return true;
		}
	}
}
