package com.example.hexagonal.domain.entity;

public class Ticket
{
	String purchaserName;
	EventEntity event;

	public Ticket(String purchaserName, EventEntity event)
	{
		this.purchaserName = purchaserName;
		this.event = event;
	}

	public String getPurchaserName()
	{
		return purchaserName;
	}

	public void setPurchaserName(String purchaserName)
	{
		this.purchaserName = purchaserName;
	}

	public EventEntity getEvent()
	{
		return event;
	}

	public void setEvent(EventEntity event)
	{
		this.event = event;
	}
}
