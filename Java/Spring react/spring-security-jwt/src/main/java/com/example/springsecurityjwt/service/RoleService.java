package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.model.Role;
import com.example.springsecurityjwt.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService
{
	final
	RoleRepository roleRepository;

	public RoleService(RoleRepository roleRepository)
	{
		this.roleRepository = roleRepository;
	}

	public List<Role> getAllRole()
	{
		return roleRepository.findAll();
	}
}
