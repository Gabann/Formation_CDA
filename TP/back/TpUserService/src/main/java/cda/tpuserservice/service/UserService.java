package cda.tpuserservice.service;

import cda.tpuserservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
	private final UserRepository repository;

	public UserService(UserRepository repository)
	{
		this.repository = repository;
	}
}
