package com.example.hexagonal.shared.dto;


import com.example.hexagonal.infra.entity.EventEntity;

public class TicketDTO
{
	String purchaserName;
	EventEntity eventEntity;
	Long id;

	public TicketDTO(String purchaserName, EventEntity event)
	{
		this.purchaserName = purchaserName;
		this.eventEntity = event;
	}

	public TicketDTO(String purchaserName, EventEntity event, Long id)
	{
		this.purchaserName = purchaserName;
		this.eventEntity = event;
		this.id = id;
	}

	public String getPurchaserName()
	{
		return purchaserName;
	}

	public EventEntity getEventEntity()
	{
		return eventEntity;
	}

	public Long getId()
	{
		return id;
	}
}
