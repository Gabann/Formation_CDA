package cda.tpdeliveryservice.service;

import cda.tpdeliveryservice.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService
{
	private final DeliveryRepository repository;

	public DeliveryService(DeliveryRepository repository)
	{
		this.repository = repository;
	}
}
