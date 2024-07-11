package com.example.rest.ex_03.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "candidate")
public class Candidate
{
	String name;
	String address;
	String phoneNumber;
	String email;
	LocalDate birthDate;
	int rating;

	@ElementCollection
	@CollectionTable(name = "candidate_observation", joinColumns = @JoinColumn(name = "candidate_id"))
	@Column(name = "observations")
	List<String> observation;

	@ElementCollection
	@CollectionTable(name = "candidate_skills", joinColumns = @JoinColumn(name = "candidate_id"))
	@Column(name = "skills")
	List<String> skills;
	String technicalArea;
	LocalDate jobInterviewDate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
}
