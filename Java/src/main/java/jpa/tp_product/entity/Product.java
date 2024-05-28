package jpa.tp_product.entity;

import javax.persistence.*;

@Entity
public abstract class Product
{
	String name;
	double price;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
}
