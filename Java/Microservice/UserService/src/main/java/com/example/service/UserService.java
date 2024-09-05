package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
	private final UserRepository repository;

	public UserService(UserRepository repository)
	{
		this.repository = repository;
	}

	public List<User> getAll()
	{
		return repository.findAll();
	}

	public User getById(Long id)
	{
		return repository.findById(id).orElse(null);
	}
}
