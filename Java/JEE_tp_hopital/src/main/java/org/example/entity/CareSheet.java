package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "care_sheet")
@NamedQueries({
		@NamedQuery(name = "CareSheet.findByPatientId", query = "select c from CareSheet c where c.patient.id = :id")
})
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

	public CareSheet(Patient patient, int durationDays, String careType)
	{
		this.patient = patient;
		this.durationDays = durationDays;
		this.careType = careType;
	}

	public CareSheet()
	{
	}

	public String getCareType()
	{
		return careType;
	}

	public int getDurationDays()
	{
		return durationDays;
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
