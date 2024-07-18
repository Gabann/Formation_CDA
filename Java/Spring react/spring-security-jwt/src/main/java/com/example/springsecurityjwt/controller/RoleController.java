package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.model.Role;
import com.example.springsecurityjwt.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth/roles")
public class RoleController
{
	final
	RoleService roleService;

	public RoleController(RoleService roleService)
	{
		this.roleService = roleService;
	}

	@GetMapping
	public ResponseEntity<List<Role>> getRoles()
	{
		return ResponseEntity.ok(roleService.getAllRole());
	}
}
