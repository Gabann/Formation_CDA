package com.example.aop.ex02.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "notification")
public class Notification
{
	String message;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "worker_id")
	private Worker worker;
	public Notification()
	{
	}

	public Notification(Worker worker, String message)
	{
		this.worker = worker;
		this.message = message;
	}
}
