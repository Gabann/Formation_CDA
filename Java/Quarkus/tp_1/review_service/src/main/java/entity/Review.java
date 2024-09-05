package entity;

import dto.BookDto;
import dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "book_id")
	Long bookId;

	@Column(name = "user_id")
	Long userId;

	int score;
	String comment;

	@Transient
	public BookDto bookDto;

	@Transient
	public UserDto userDto;
}
