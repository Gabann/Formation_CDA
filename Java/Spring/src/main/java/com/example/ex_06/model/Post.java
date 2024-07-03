package com.example.ex_06.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(columnDefinition="TEXT")
	String content;

	LocalDate postingDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
