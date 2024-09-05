package entity;

import dto.BookDto;
import dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "borrow")
public class Borrow
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "book_id")
	Long bookId;

	@Column(name = "user_id")
	Long userId;

	LocalDate startDate;
	LocalDate endDate;

	@Transient
	public BookDto bookDto;

	@Transient
	public UserDto userDto;
}
