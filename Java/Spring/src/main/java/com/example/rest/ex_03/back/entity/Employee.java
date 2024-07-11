package com.example.rest.ex_03.back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee
{
	String name;
	String address;
	String phoneNumber;
	String email;
	LocalDate birthDate;
	LocalDate contractStart;
	LocalDate contractEnd;
	String occupation;
	String password;
	boolean admin;
	int salary;

	@ElementCollection
	@CollectionTable(name = "employee_observation", joinColumns = @JoinColumn(name = "employee_id"))
	@Column(name = "observations")
	List<String> observation;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
}
