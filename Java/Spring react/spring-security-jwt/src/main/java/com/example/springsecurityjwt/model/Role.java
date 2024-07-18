package com.example.springsecurityjwt.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority
{
	String role;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Override
	public String getAuthority()
	{
		return this.role;
	}
}
