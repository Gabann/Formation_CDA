package org.example.jee.ex_06.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
@NamedQueries({
		@NamedQuery(name = "User.findByUsername", query = "select u from User u where u.username = :username")
})
public class User
{
	String email;
	String username;
	String password;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	public User()
	{
	}

	public User(String email, String name, String password)
	{
		this.email = email;
		this.username = name;
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}
}
