package com.example.hexagonal.shared.port;

import com.example.hexagonal.shared.dto.EventDTO;

import java.util.List;

public interface EventPort
{
	EventDTO save(EventDTO eventDTO);

	List<EventDTO> get();
}
