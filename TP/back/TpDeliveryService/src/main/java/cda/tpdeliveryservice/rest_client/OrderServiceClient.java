package cda.tpdeliveryservice.rest_client;

import cda.tpdeliveryservice.dto.OrderDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceClient
{
	private static final String BASE_URL = "http://localhost:3602";
	private final RestTemplate restTemplate;

	public OrderServiceClient(RestTemplate restTemplate)
	{
		this.restTemplate = restTemplate;
	}

	public OrderDto getOrderById(Long id)
	{
		String url = BASE_URL + "/api/orders/" + id;
		return restTemplate.getForObject(url, OrderDto.class);
	}
}
