package com.example.springsecurityjwt.dto;

import com.example.springsecurityjwt.model.Role;
import com.example.springsecurityjwt.model.User;

import java.util.List;

public class UserRegistrationDto
{
	private User user;
	private List<Role> roles;

	// Getters and Setters
	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public List<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(List<Role> roles)
	{
		this.roles = roles;
	}
}
