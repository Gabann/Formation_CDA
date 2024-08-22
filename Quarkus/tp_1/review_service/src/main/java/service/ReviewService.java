package service;

import dto.BookDto;
import dto.UserDto;
import entity.Review;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import repository.ReviewRepository;
import rest_client.BookServiceClient;
import rest_client.UserServiceClient;

import java.util.List;

@ApplicationScoped
public class ReviewService
{
	@Inject
	ReviewRepository repository;

	@Inject
	@RestClient
	BookServiceClient bookServiceClient;

	@Inject
	@RestClient
	UserServiceClient userServiceClient;

	private Review enrichWithDtoDetails(Review review)
	{
		if (review == null)
		{
			return null;
		}

		BookDto bookDto = bookServiceClient.getBookById(review.getBookId());

		if (bookDto == null)
		{
			throw new WebApplicationException("Book not found for ID " + review.getBookId(), 404);
		}

		UserDto userDto = userServiceClient.getUserById(review.getUserId());

		if (userDto == null)
		{
			throw new WebApplicationException("User not found for ID " + review.getUserId(), 404);
		}

		review.setBookDto(bookDto);
		review.setUserDto(userDto);

		return review;
	}

	public List<Review> getAll()
	{
		List<Review> reviews = repository.listAll();

		return reviews.stream()
				.map(review -> this.enrichWithDtoDetails(review))
				.toList();
	}

	public Review getById(Long id)
	{
		Review review =  repository.findById(id);
		return this.enrichWithDtoDetails(review);
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
	public void create(Review review)
	{
		repository.persist(review);
	}

	@Transactional
	public boolean updateById(Long id, Review newReview)
	{
		Review existingReview = repository.findById(id);
		if (existingReview == null)
		{
			return false;
		}

		existingReview.setScore(newReview.getScore());
		existingReview.setComment(newReview.getComment());
		existingReview.setUserId(newReview.getUserId());
		existingReview.setBookId(newReview.getBookId());
		repository.persist(existingReview);
		return true;
	}
}
