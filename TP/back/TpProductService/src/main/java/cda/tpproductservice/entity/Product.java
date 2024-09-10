package cda.tpproductservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product
{
	@Column(name = "name", nullable = false)
	String name;
	@Column(name = "description", nullable = false)
	String description;
	@Column(name = "price", nullable = false)
	double price;
	@Column(name = "stock", nullable = false)
	int stock;
	@Column(name = "category", nullable = false)
	@Enumerated(EnumType.STRING)
	ProductCategory category;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	public enum ProductCategory
	{
		CATEGORY_1,
		CATEGORY_2,
		CATEGORY_3
	}
}
