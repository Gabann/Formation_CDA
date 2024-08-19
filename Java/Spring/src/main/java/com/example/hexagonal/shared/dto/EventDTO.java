package com.example.hexagonal.shared.dto;

import com.example.hexagonal.shared.enums.EventTypes;

import java.time.LocalDate;

public class EventDTO
{
	LocalDate date;
	EventTypes eventType;
	Long id;

	public EventDTO(LocalDate date, EventTypes eventType)
	{
		this.date = date;
		this.eventType = eventType;
	}

	public EventDTO(LocalDate date, EventTypes eventType, Long id)
	{
		this.date = date;
		this.eventType = eventType;
		this.id = id;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public EventTypes getEventType()
	{
		return eventType;
	}

	public Long getId()
	{
		return id;
	}
}
