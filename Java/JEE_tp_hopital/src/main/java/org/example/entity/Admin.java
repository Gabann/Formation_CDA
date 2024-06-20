package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
@NamedQueries({
		@NamedQuery(name = "Admin.findByUsername", query = "select a from Admin a where a.username = :username")
})
public class Admin
{
	String username;
	String password;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	public Admin()
	{
	}

	public Admin(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

}
