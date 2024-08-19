package com.example.hexagonal.infra.entity;

import com.example.hexagonal.shared.enums.EventTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "event_entity")
public class EventEntity
{
	LocalDate date;
	EventTypes eventType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;


	public EventEntity()
	{

	}
}
