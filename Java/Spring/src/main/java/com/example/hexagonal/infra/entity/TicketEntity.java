package com.example.hexagonal.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "ticket_entity")
public class TicketEntity
{
	String purchaserName;
	@ManyToOne
	@JoinColumn(name = "event_id")
	EventEntity event;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	public TicketEntity()
	{

	}
}
