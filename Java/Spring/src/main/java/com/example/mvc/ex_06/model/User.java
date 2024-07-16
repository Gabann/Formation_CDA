package com.example.mvc.ex_06.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mvcUser")
@Table(name = "mvc_user")
public class User
{
	String username;
	String password;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	public User()
	{
	}

	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
}
