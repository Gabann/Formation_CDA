package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "care_sheet")
public class CareSheet
{
	String careType;
	int durationDays;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	public CareSheet()
	{
	}

	public Patient getPatient()
	{
		return patient;
	}

	public void setPatient(Patient patient)
	{
		this.patient = patient;
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
