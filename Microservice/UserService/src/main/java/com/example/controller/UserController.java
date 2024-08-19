package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
	private final UserService service;

	public UserController(UserService service)
	{
		this.service = service;
		System.out.println("UserController initialized");
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAll()
	{
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id)
	{
		return ResponseEntity.ok(service.getById(id));
	}
}
