package com.example.hexagonal.infra.port_impl;

import com.example.hexagonal.infra.entity.EventEntity;
import com.example.hexagonal.infra.repository.EventEntityRepository;
import com.example.hexagonal.shared.dto.EventDTO;
import com.example.hexagonal.shared.port.EventPort;

import java.util.List;

public class EventPortImpl implements EventPort
{
	private final EventEntityRepository repository;

	public EventPortImpl(EventEntityRepository repository)
	{
		this.repository = repository;
	}

	@Override
	public EventDTO save(EventDTO eventDTO)
	{
		EventEntity eventEntity = EventEntity.builder().eventType(eventDTO.getEventType()).date(eventDTO.getDate()).build();
		eventEntity = repository.save(eventEntity);
		return new EventDTO(eventEntity.getDate(), eventEntity.getEventType(), eventEntity.getId());
	}

	@Override
	public List<EventDTO> get()
	{
		return ((List<EventEntity>) repository.findAll()).stream()
				.map(eventEntity -> new EventDTO(eventEntity.getDate(), eventEntity.getEventType(), eventEntity.getId()))
				.toList();
	}
}
