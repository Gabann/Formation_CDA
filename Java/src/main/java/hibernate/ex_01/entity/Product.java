package hibernate.ex_01.entity;

import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "brand")
	private String brand;

	@Column(name = "reference")
	private String reference;

	@Column(name = "purchase_date")
	private LocalDateTime purchaseDate;

	@Column(name = "price")
	private double price;

	@Column(name = "stock")
	private int stock;

	public Product(Builder builder)
	{
		brand = builder.brand;
		purchaseDate = builder.purchaseDate;
		price = builder.price;
		stock = builder.stock;
	}

	public Product()
	{
	}

	public static final class Builder
	{
		private String brand;
		private LocalDateTime purchaseDate;
		private double price;
		private int stock;

		public Builder()
		{
		}

		public Builder brand(String val)
		{
			brand = val;
			return this;
		}

		public Builder purchaseDate(LocalDateTime val)
		{
			purchaseDate = val;
			return this;
		}

		public Builder price(double val)
		{
			price = val;
			return this;
		}

		public Builder stock(int val)
		{
			stock = val;
			return this;
		}

		public Product build()
		{
			return new Product(this);
		}
	}
}
