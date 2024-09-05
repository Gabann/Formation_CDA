package entity;

import dto.AuthorDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "author_id")
	Long authorId;

	String title;
	String isbn;

	@Transient
	AuthorDto authorDto;
}
