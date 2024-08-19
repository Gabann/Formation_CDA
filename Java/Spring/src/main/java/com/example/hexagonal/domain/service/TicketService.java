package com.example.hexagonal.domain.service;


import com.example.hexagonal.infra.entity.EventEntity;
import com.example.hexagonal.shared.dto.TicketDTO;
import com.example.hexagonal.shared.port.TicketPort;

import java.util.List;

public class TicketService
{
	private final TicketPort ticketPort;

	public TicketService(TicketPort ticketPort)
	{
		this.ticketPort = ticketPort;
	}

	public TicketDTO save(String purchaserName, EventEntity event)
	{
		TicketDTO ticketDTO = new TicketDTO(purchaserName, event);
		ticketDTO = ticketPort.set(ticketDTO);
		return ticketDTO;
	}

	public List<TicketDTO> get()
	{
		return ticketPort.get();
	}
}
