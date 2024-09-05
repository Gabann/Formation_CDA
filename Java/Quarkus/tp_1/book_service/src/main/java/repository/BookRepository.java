package repository;

import entity.Book;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class BookRepository implements PanacheRepository<Book>
{
	public List<Book> getBooksNotBorrowed() {
		return null;
	}

	public Book getByIsbn(String isbn) {
		return find("isbn", isbn).firstResult();
	}
}
