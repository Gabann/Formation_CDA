package service;

import entity.Author;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import repository.AuthorRepository;

import java.util.List;

@ApplicationScoped
public class AuthorService
{
	@Inject
	AuthorRepository repository;

	public List<Author> getAll()
	{
		return repository.listAll();
	}

	public Author getById(Long id)
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
	public void create(Author author)
	{
		repository.persist(author);
	}

	@Transactional
	public boolean updateById(Long id, Author newAuthor)
	{
		Author existingAuthor = repository.findById(id);
		if (existingAuthor == null)
		{
			return false;
		}

		existingAuthor.setName(newAuthor.getName());
		existingAuthor.setBiographie(newAuthor.getBiographie());
		existingAuthor.setBirthDate(newAuthor.getBirthDate());
		repository.persist(existingAuthor);
		return true;
	}
}
