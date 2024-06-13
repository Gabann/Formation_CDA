package org.example.jee.ex_06.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product
{
	String brand;
	String reference;
	LocalDate purchaseDate;
	double price;
	int stock;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	public Product()
	{
	}

	public Product(String brand, String reference, LocalDate purchaseDate, double price, int stock)
	{
		this.brand = brand;
		this.reference = reference;
		this.purchaseDate = purchaseDate;
		this.price = price;
		this.stock = stock;
	}

	public String getBrand()
	{
		return brand;
	}

	public String getReference()
	{
		return reference;
	}

	public LocalDate getPurchaseDate()
	{
		return purchaseDate;
	}

	public double getPrice()
	{
		return price;
	}

	public int getStock()
	{
		return stock;
	}

	public Long getId()
	{
		return id;
	}

}
