package hibernate.ex_01.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Comment
{
	String content;
	LocalDate commentDate = LocalDate.now();
	double score;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public Comment()
	{
	}

	private Comment(Builder builder)
	{
		content = builder.content;
		commentDate = builder.commentDate;
		score = builder.score;
		product = builder.product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}

	public static final class Builder
	{
		private String content;
		private LocalDate commentDate = LocalDate.now();
		private double score;
		private Product product;

		public Builder(Product product)
		{
			this.product = product;
		}

		public Builder content(String val)
		{
			content = val;
			return this;
		}

		public Builder commentDate(LocalDate val)
		{
			commentDate = val;
			return this;
		}

		public Builder score(double val)
		{
			score = val;
			return this;
		}

		public Builder productId(Product val)
		{
			product = val;
			return this;
		}

		public Comment build()
		{
			return new Comment(this);
		}
	}
}
