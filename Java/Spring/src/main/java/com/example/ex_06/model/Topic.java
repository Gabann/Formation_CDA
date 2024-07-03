package com.example.ex_06.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "topic")
public class Topic
{
	String title;
	LocalDate creationDate;
	LocalDate lastUpdateDate;
	@OneToOne(orphanRemoval = true)
	@JoinColumn(name = "author_id")
	private User author;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	public Topic()
	{
	}

	public Topic(User author, LocalDate lastUpdateDate, LocalDate creationDate, String title)
	{
		this.author = author;
		this.lastUpdateDate = lastUpdateDate;
		this.creationDate = creationDate;
		this.title = title;
	}
}
