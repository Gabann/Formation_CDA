package com.example.security.ex_01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String roles;

	private boolean isEnabled = true;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return Arrays
				.stream(roles.split(","))
				.map(SimpleGrantedAuthority::new)
				.toList();
	}

	@Override
	public String getPassword()
	{
		return password;
	}

	@Override
	public String getUsername()
	{
		return username;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return UserDetails.super.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return UserDetails.super.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return UserDetails.super.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled()
	{
		return isEnabled;
	}
}
