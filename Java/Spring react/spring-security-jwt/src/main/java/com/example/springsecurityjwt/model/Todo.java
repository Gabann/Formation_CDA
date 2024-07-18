package com.example.springsecurityjwt.model;

import com.example.springsecurityjwt.enums.TodoStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "todo")
public class Todo
{
	String title;
	String description;
	@Enumerated(EnumType.ORDINAL)
	TodoStatus status;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}

