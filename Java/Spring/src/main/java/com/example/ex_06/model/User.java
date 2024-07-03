package com.example.ex_06.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	String username;
	String password;

	public User()
	{
	}

	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
}
