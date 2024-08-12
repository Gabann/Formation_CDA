package com.example.aop.ex02.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "task")
public class Task
{
	TaskStatus status;
	String title;
	String description;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	public enum TaskStatus
	{
		DONE,
		IN_PROGRESS,
		NOT_STARTED
	}

}
