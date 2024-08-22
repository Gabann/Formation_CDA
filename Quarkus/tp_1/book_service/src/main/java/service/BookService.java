package service;

import dto.AuthorDto;
import entity.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import repository.BookRepository;
import rest_client.AuthorServiceClient;

import java.util.List;

@ApplicationScoped
public class BookService
{
	@Inject
	BookRepository repository;

	@Inject
	@RestClient
	AuthorServiceClient authorServiceClient;

	private Book enrichWithDtoDetails(Book book)
	{
		if (book == null)
		{
			return null;
		}

		AuthorDto authorDto = authorServiceClient.getAuthorById(book.getId());

		if (authorDto == null)
		{
			throw new WebApplicationException("Author not found for ID " + book.getAuthorId(), 404);
		}

		book.setAuthorDto(authorDto);

		return book;
	}

	public List<Book> getAll()
	{
		List<Book> reviews = repository.listAll();

		return reviews.stream()
				.map(review -> this.enrichWithDtoDetails(review))
				.toList();
	}

	public Book getById(Long id)
	{
		Book book = repository.findById(id);
		return this.enrichWithDtoDetails(book);
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
	public void create(Book book)
	{
		repository.persist(book);
	}

	@Transactional
	public boolean updateById(Long id, Book newBook)
	{
		Book existingBook = repository.findById(id);
		if (existingBook != null)
		{
			return false;
		}

		existingBook.setTitle(newBook.getTitle());
		existingBook.setIsbn(newBook.getIsbn());
		repository.persist(existingBook);
		return true;
	}
}
