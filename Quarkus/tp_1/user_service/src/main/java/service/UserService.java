package service;

import entity.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import repository.UserRepository;

import java.util.List;

@ApplicationScoped
public class UserService
{
	@Inject
	UserRepository repository;

	public List<User> getAll()
	{
		return repository.listAll();
	}

	public User getById(Long id)
	{
		return repository.findById(id);
	}

	@Transactional
	public boolean deleteById(Long id)
	{
		if (repository.findById(id) != null)
		{
			repository.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Transactional
	public void create(User user)
	{
		repository.persist(user);
	}

	@Transactional
	public boolean updateById(Long id, User newUser)
	{
		User existingUser = repository.findById(id);
		if (existingUser != null)
		{
			return false;
		}

		existingUser.setUsername(newUser.getUsername());
		existingUser.setPassword(newUser.getPassword());
		repository.persist(existingUser);
		return true;
	}
}
