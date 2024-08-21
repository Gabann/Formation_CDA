package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.entity.Client;
import org.example.repository.ClientRepository;

import java.util.List;

@ApplicationScoped
public class ClientService
{
	@Inject
	ClientRepository repository;

	public List<Client> getAll()
	{
		return repository.listAll();
	}

	public Client getById(Long id)
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
	public void create(Client client)
	{
		repository.persist(client);
	}

	@Transactional
	public boolean updateById(Long id, Client newClient)
	{
		Client existingClient = repository.findById(id);
		if (existingClient != null)
		{
			return false;
		}

		existingClient.setName(newClient.getName());
		existingClient.setEmail(newClient.getEmail());
		existingClient.setPhoneNumber(newClient.getPhoneNumber());
		repository.persist(existingClient);
		return true;
	}
}
