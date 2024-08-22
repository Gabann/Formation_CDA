package service;

import dto.BookDto;
import dto.UserDto;
import entity.Borrow;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import repository.BorrowRepository;
import rest_client.BookServiceClient;
import rest_client.UserServiceClient;

import java.awt.print.Book;
import java.util.List;

@ApplicationScoped
public class BorrowService
{
	@Inject
	BorrowRepository repository;

	@Inject
	@RestClient
	BookServiceClient bookServiceClient;

	@Inject
	@RestClient
	UserServiceClient userServiceClient;

	private Borrow enrichWithDtoDetails(Borrow borrow)
	{
		if (borrow == null)
		{
			return null;
		}

		BookDto bookDto = bookServiceClient.getBookById(borrow.getBookId());

		if (bookDto == null)
		{
			throw new WebApplicationException("Book not found for ID " + borrow.getBookId(), 404);
		}

		UserDto userDto = userServiceClient.getUserById(borrow.getUserId());

		if (userDto == null)
		{
			throw new WebApplicationException("User not found for ID " + borrow.getUserId(), 404);
		}

		borrow.setBookDto(bookDto);
		borrow.setUserDto(userDto);

		return borrow;
	}

	public List<Borrow> getAll()
	{
		List<Borrow> borrows = repository.listAll();

		return borrows.stream()
				.map(review -> this.enrichWithDtoDetails(review))
				.toList();
	}

	public Borrow getById(Long id)
	{
		Borrow borrow    =  repository.findById(id);
		return this.enrichWithDtoDetails(borrow);
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
	public void create(Borrow borrow)
	{
		repository.persist(borrow);
	}

	@Transactional
	public boolean updateById(Long id, Borrow newBorrow)
	{
		Borrow existingBorrow = repository.findById(id);
		if (existingBorrow != null)
		{
			return false;
		}

		existingBorrow.setStartDate(newBorrow.getStartDate());
		existingBorrow.setEndDate(newBorrow.getEndDate());
		existingBorrow.setBookId(newBorrow.getBookId());
		existingBorrow.setUserId(newBorrow.getUserId());
		repository.persist(existingBorrow);
		return true;
	}
}
