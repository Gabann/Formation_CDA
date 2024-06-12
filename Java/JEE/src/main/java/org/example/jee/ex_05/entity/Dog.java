package org.example.jee.ex_05.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "dog")
public class Dog
{
	String name;
	String breed;
	LocalDate dateOfBirth;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	public Dog()
	{
	}

	public Dog(String name, String breed, LocalDate dateOfBirth)
	{
		this.name = name;
		this.breed = breed;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName()
	{
		return name;
	}

	public String getBreed()
	{
		return breed;
	}

	public LocalDate getDateOfBirth()
	{
		return dateOfBirth;
	}

	public Long getId()
	{
		return id;
	}
}
