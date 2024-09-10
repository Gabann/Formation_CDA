package cda.tpdeliveryservice.controller;

import cda.tpdeliveryservice.service.DeliveryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController
{
	private final DeliveryService service;

	public DeliveryController(DeliveryService service)
	{
		this.service = service;
	}
}
