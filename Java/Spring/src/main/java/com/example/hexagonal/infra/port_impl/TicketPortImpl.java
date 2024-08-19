package com.example.hexagonal.infra.port_impl;


import com.example.hexagonal.infra.entity.TicketEntity;
import com.example.hexagonal.infra.repository.TicketEntityRepository;
import com.example.hexagonal.shared.dto.TicketDTO;
import com.example.hexagonal.shared.port.TicketPort;

import java.util.List;

public class TicketPortImpl implements TicketPort
{
	private final TicketEntityRepository repository;

	public TicketPortImpl(TicketEntityRepository repository)
	{
		this.repository = repository;
	}

	@Override
	public TicketDTO set(TicketDTO ticket)
	{
		TicketEntity ticketEntity = TicketEntity.builder().purchaserName(ticket.getPurchaserName()).event(ticket.getEventEntity()).build();
		ticketEntity = repository.save(ticketEntity);
		return new TicketDTO(ticketEntity.getPurchaserName(), ticketEntity.getEvent(), ticketEntity.getId());
	}

	@Override
	public List<TicketDTO> get()
	{
		return ((List<TicketEntity>) repository.findAll()).stream()
				.map(ticketEntity -> new TicketDTO(ticketEntity.getPurchaserName(), ticketEntity.getEvent(), ticketEntity.getId()))
				.toList();
	}
}
