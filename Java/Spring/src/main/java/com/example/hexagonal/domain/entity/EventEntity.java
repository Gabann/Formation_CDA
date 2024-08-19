package com.example.hexagonal.domain.entity;

import com.example.hexagonal.shared.enums.EventTypes;

import java.time.LocalDate;

public class EventEntity
{
	LocalDate date;
	EventTypes eventType;

	public EventEntity(LocalDate date, EventTypes eventType)
	{
		this.date = date;
		this.eventType = eventType;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public void setDate(LocalDate date)
	{
		this.date = date;
	}

	public EventTypes getEventType()
	{
		return eventType;
	}

	public void setEventType(EventTypes eventType)
	{
		this.eventType = eventType;
	}

}
