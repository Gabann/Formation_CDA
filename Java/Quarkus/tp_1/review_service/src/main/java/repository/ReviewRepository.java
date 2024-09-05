package repository;

import entity.Review;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ReviewRepository implements PanacheRepository<Review>
{
	public List<Review> getByScore(int score) {
		return find("score = ?1", score).list();
	}

	public List<Review> getByUserId(Long userId) {
		return find("userId = ?1", userId).list();
	}

	public List<Review> getByBookId(Long bookId) {
		return find("bookId = ?1", bookId).list();
	}
}
