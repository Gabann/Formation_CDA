package com.example.rest.ex_03.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vacations")
public class Vacation
{
	LocalDate startDate;
	LocalDate entDate;
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "candidate_id")
	private Set<Employee> employees = new LinkedHashSet<>();
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
}
