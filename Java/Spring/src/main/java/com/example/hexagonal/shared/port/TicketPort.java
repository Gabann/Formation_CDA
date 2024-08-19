package com.example.hexagonal.shared.port;

import com.example.hexagonal.shared.dto.TicketDTO;

import java.util.List;

public interface TicketPort
{
	TicketDTO set(TicketDTO ticket);

	List<TicketDTO> get();
}
