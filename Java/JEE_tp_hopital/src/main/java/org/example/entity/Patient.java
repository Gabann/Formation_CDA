package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient
{
	String firstName;
	String lastName;
	LocalDate birthDate;
	String imagePath;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@OneToMany(mappedBy = "patient", orphanRemoval = true)
	private Set<CareSheet> careSheets = new LinkedHashSet<>();

	public Patient(String firstName, String lastName, LocalDate birthDate, String imagePath)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.imagePath = imagePath;
	}

	public Patient()
	{
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public LocalDate getBirthDate()
	{
		return birthDate;
	}

	public String getImagePath()
	{
		return imagePath;
	}

	public Set<CareSheet> getCareSheets()
	{
		return careSheets;
	}

	public void setCareSheets(Set<CareSheet> careSheets)
	{
		this.careSheets = careSheets;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
}
