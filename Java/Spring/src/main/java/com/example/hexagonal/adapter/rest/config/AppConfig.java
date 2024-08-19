package com.example.hexagonal.adapter.rest.config;


import com.example.hexagonal.domain.service.EventService;
import com.example.hexagonal.domain.service.TicketService;
import com.example.hexagonal.infra.port_impl.EventPortImpl;
import com.example.hexagonal.infra.port_impl.TicketPortImpl;
import com.example.hexagonal.infra.repository.EventEntityRepository;
import com.example.hexagonal.infra.repository.TicketEntityRepository;
import com.example.hexagonal.shared.port.EventPort;
import com.example.hexagonal.shared.port.TicketPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
	private final TicketEntityRepository ticketEntityRepository;
	private final EventEntityRepository eventEntityRepository;

	public AppConfig(TicketEntityRepository ticketEntityRepository, EventEntityRepository eventEntityRepository)
	{
		this.ticketEntityRepository = ticketEntityRepository;
		this.eventEntityRepository = eventEntityRepository;
	}

	@Bean
	public EventService eventService()
	{
		return new EventService(eventPort());
	}

	@Bean
	public EventPort eventPort()
	{
		return new EventPortImpl(eventEntityRepository);
	}

	@Bean
	public TicketService ticketService()
	{
		return new TicketService(ticketPort());
	}

	public TicketPort ticketPort()
	{
		return new TicketPortImpl(ticketEntityRepository);
	}
}
