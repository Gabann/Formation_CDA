package com.example.aop.ex02.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project
{
	String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToMany
	@JoinTable(name = "project_workers",
	           joinColumns = @JoinColumn(name = "project_id"),
	           inverseJoinColumns = @JoinColumn(name = "workers_id"))
	private Set<Worker> workers = new LinkedHashSet<>();

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Task> tasks = new LinkedHashSet<>();

}
