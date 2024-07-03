package com.example.ex_06.service;

import com.example.ex_06.model.User;
import com.example.ex_06.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
	private final UserRepository repository;

	public UserService(UserRepository userRepository)
	{
		this.repository = userRepository;

		repository.save(new User("username", "password"));
		repository.save(new User("admin", "admin"));
	}

	public List<User> getAll()
	{
		return repository.findAll();
	}

	public User getById(Long id)
	{
		return repository.findById(id).orElse(null);
	}

	public User getByUsername(String username)
	{
		return repository.findByUsername(username);
	}
}
