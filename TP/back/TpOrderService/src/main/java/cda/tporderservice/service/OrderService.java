package cda.tporderservice.service;

import cda.tporderservice.dto.ProductDto;
import cda.tporderservice.dto.UserDto;
import cda.tporderservice.entity.Order;
import cda.tporderservice.repository.OrderRepository;
import cda.tporderservice.rest_client.ProductServiceClient;
import cda.tporderservice.rest_client.UserServiceClient;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

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

		for (Map.Entry<Long, Integer> entry : order.getProductQuantities().entrySet())
		{
			Long productId = entry.getKey();
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


	@Transactional
	public ResponseEntity<?> create(Order order)
	{
		//We use a double for because the stock decrement is made in a separate microservice and does not get rolled back if the method fails
		//TODO check for kafka saga pattern to handle this better
		for (Map.Entry<Long, Integer> entry : order.getProductQuantities().entrySet())
		{
			Long productId = entry.getKey();
			int quantity = entry.getValue();

			ProductDto productDto = productServiceClient.getProductById(productId);

			if (productDto == null)
			{
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("Product not found for ID " + productId);
			}

			if (productDto.getStock() < quantity)
			{
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Not enough stock for product ID " + productId);
			}

		}

		for (Map.Entry<Long, Integer> entry : order.getProductQuantities().entrySet())
		{
			Long productId = entry.getKey();
			int quantity = entry.getValue();

			productServiceClient.decrementProductStock(productId, quantity);
		}

		return ResponseEntity.ok(repository.save(order));
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

	@Transactional
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

	@Transactional
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
