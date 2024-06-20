package org.example.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "meds")
@NamedQueries({
		@NamedQuery(name = "Meds.findByCareSheets_Id",
		            query = "select m from Meds m inner join m.careSheets careSheets where careSheets.id = :id")
})
public class Meds
{
	String medsType;
	int durationDays;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "meds_careSheets",
	           joinColumns = @JoinColumn(name = "meds_id"),
	           inverseJoinColumns = @JoinColumn(name = "careSheets_id"))
	private Set<CareSheet> careSheets = new LinkedHashSet<>();

	public Meds()
	{
	}

	public Meds(String medsType, int durationDays, Set<CareSheet> careSheets)
	{
		this.medsType = medsType;
		this.durationDays = durationDays;
		this.careSheets = careSheets;
	}

	public Set<CareSheet> getCareSheets()
	{
		return careSheets;
	}

	public void setCareSheets(Set<CareSheet> careSheets)
	{
		this.careSheets = careSheets;
	}

	public String getMedsType()
	{
		return medsType;
	}

	public int getDurationDays()
	{
		return durationDays;
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
