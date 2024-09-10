package cda.tporderservice.service;

import cda.tporderservice.dto.ProductDto;
import cda.tporderservice.dto.UserDto;
import cda.tporderservice.entity.Order;
import cda.tporderservice.repository.OrderRepository;
import cda.tporderservice.rest_client.ProductServiceClient;
import cda.tporderservice.rest_client.UserServiceClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderService
{
	private final UserServiceClient userServiceClient;
	private final OrderRepository repository;
	private final ProductServiceClient productServiceClient;

	public OrderService(OrderRepository repository, ProductServiceClient productServiceClient, UserServiceClient userServiceClient)
	{
		this.repository = repository;
		this.productServiceClient = productServiceClient;
		this.userServiceClient = userServiceClient;
	}

	public Order getById(Long id)
	{
		Order order = repository.findById(id).orElse(null);
		return enrichWithDto(order);
	}

	private Order enrichWithDto(Order order)
	{
		if (order == null)
		{
			return null;
		}

		UserDto userDto = userServiceClient.getUserById(order.getUserId());

		if (userDto == null)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found for ID " + order.getUserId());
		}

		order.setUserDto(userDto);

		for (Long productId : order.getProductIds())
		{
			ProductDto productDto = productServiceClient.getProductById(productId);

			if (productDto == null)
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found for ID " + productId);
			}

			order.getProductsDto().add(productDto);
		}

		order.setUserDto(userDto);

		return order;
	}

	public Order create(Order order)
	{
		return repository.save(order);
	}

	public List<Order> getAll()
	{
		List<Order> orders = repository.findAll();

		for (Order order : orders)
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

	public boolean updateById(Long id, Order newOrder)
	{
		Order existingOrder = repository.findById(id).orElse(null);
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
