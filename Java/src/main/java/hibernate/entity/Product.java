package hibernate.entity;

import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "product")
@Setter
@NamedQueries({
		@NamedQuery(name = "Product.findByPurchaseDateBetween",
				query = "select p from Product p where p.purchaseDate between :purchaseDateStart and :purchaseDateEnd"),
		@NamedQuery(name = "Product.findByPriceGreaterThan",
				query = "select p from Product p where p.price > :price"),
		@NamedQuery(name = "Product.findStockByBrand",
				query = "select p.stock from Product p where p.brand = :brand"),
		@NamedQuery(name = "Product.findAveragePrice",
				query = "select avg(p.price) from Product p"),
		@NamedQuery(name = "Product.findByBrand",
				query = "select p from Product p where p.brand = :brand"),
		@NamedQuery(name = "Product.deleteByBrand",
				query = "delete from Product p where p.brand = :brand"),
})

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
	private LocalDate purchaseDate;

	@Column(name = "price")
	private double price;

	@Column(name = "stock")
	private int stock;

	@OneToOne(orphanRemoval = true)
	@JoinColumn(name = "image_id")
	private Image image;

	@OneToMany(mappedBy = "product", orphanRemoval = true)
	private Set<Comment> comments = new LinkedHashSet<>();

	public Product()
	{
	}

	private Product(Builder builder)
	{
		setStock(builder.stock);
		setPrice(builder.price);
		setPurchaseDate(builder.purchaseDate);
		setReference(builder.reference);
		setBrand(builder.brand);
	}

	public Set<Comment> getComments()
	{
		return comments;
	}

	public Image getImage()
	{
		return image;
	}

	public void addComment(Comment comment)
	{
		comments.add(comment);
		comment.setProduct(this);
	}

	public void addImage(Image image)
	{
		this.image = image;
	}

	@Override
	public String toString()
	{
		return "Product{" +
				"id=" + id +
				", brand='" + brand + '\'' +
				", reference='" + reference + '\'' +
				", purchaseDate=" + purchaseDate +
				", price=" + price +
				", stock=" + stock +
				'}';
	}

	public static final class Builder
	{
		private int stock;
		private double price;
		private LocalDate purchaseDate;
		private String reference;
		private String brand;

		public Builder()
		{
		}

		public Builder stock(int val)
		{
			stock = val;
			return this;
		}

		public Builder price(double val)
		{
			price = val;
			return this;
		}

		public Builder purchaseDate(LocalDate val)
		{
			purchaseDate = val;
			return this;
		}

		public Builder reference(String val)
		{
			reference = val;
			return this;
		}

		public Builder brand(String val)
		{
			brand = val;
			return this;
		}

		public Product build()
		{
			return new Product(this);
		}
	}
}
