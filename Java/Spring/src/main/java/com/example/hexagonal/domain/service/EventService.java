package com.example.hexagonal.domain.service;

import com.example.hexagonal.shared.dto.EventDTO;
import com.example.hexagonal.shared.enums.EventTypes;
import com.example.hexagonal.shared.port.EventPort;

import java.time.LocalDate;
import java.util.List;

public class EventService
{
	private final EventPort eventPort;

	public EventService(EventPort eventPort)
	{
		this.eventPort = eventPort;
	}

	public EventDTO save(LocalDate date, EventTypes eventType)
	{
		EventDTO eventDTO = new EventDTO(date, eventType);
		eventDTO = eventPort.save(eventDTO);
		return eventDTO;
	}

	public List<EventDTO> get()
	{
		return eventPort.get();
	}
}
