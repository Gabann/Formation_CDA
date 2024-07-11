package com.example.rest.ex_03.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "vacations")
public class Vacation
{
	LocalDate startDate;
	LocalDate entDate;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
}
