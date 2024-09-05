package repository;

import entity.Borrow;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@ApplicationScoped
public class BorrowRepository implements PanacheRepository<Borrow>
{
	public List<Borrow> getCurrentBorrows() {
		return getEntityManager().createQuery(
						"SELECT b FROM Borrow b WHERE b.endDate IS NULL OR b.endDate > CURRENT_DATE", Borrow.class)
				.getResultList();
	}

	public List<Borrow> getBorrowsBetweenDates(LocalDate startDate, LocalDate endDate) {
		return find("startDate >= ?1 AND endDate <= ?2", startDate, endDate).list();
	}

	public List<Borrow> getBorrowsByUserId(Long userId)
	{
		return find("userId = ?1", userId).list();
	}

	public boolean isBookBorrowed(Long bookId) {
		LocalDate currentDate = LocalDate.now();
		return find("bookId = ?1 AND endDate > ?2", bookId, currentDate).firstResult() != null;
	}
}
