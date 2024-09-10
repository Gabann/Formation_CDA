package cda.tporderservice.rest_client;

import cda.tporderservice.dto.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceClient
{
	private static final String BASE_URL = "http://localhost:3605";
	private final RestTemplate restTemplate;

	public UserServiceClient(RestTemplate restTemplate)
	{
		this.restTemplate = restTemplate;
	}

	public UserDto getUserById(Long id)
	{
		String url = BASE_URL + "/" + id;
		return restTemplate.getForObject(url, UserDto.class);
	}
}
