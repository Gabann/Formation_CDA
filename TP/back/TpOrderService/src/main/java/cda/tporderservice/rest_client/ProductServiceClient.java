package cda.tporderservice.rest_client;

import cda.tporderservice.dto.ProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceClient
{
	private static final String BASE_URL = "http://localhost:3603";
	private final RestTemplate restTemplate;

	public ProductServiceClient(RestTemplate restTemplate)
	{
		this.restTemplate = restTemplate;
	}

	public ProductDto getProductById(Long id)
	{
		String url = BASE_URL + "/api/products/" + id;
		return restTemplate.getForObject(url, ProductDto.class);
	}

	public void decrementProductStock(Long id)
	{
		String url = BASE_URL + "/api/products/" + id + "/decrement";
		restTemplate.put(url, null);
	}

	public void decrementProductStock(Long id, int quantity)
	{
		String url = BASE_URL + "/api/products/" + id + "/decrement";
		restTemplate.put(url, quantity);
	}
}
