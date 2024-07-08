package com.example.mvc.ex_02.model;

import java.util.HashMap;
import java.util.Map;

public class Product
{
	public static Map<Long, Product> productMap = new HashMap<>();
	static Long productCount = 0L;
	Long id;
	String name;
	String category;
	double price;

	public Product(String name, String category, double price)
	{
		this.id = ++productCount;
		this.name = name;
		this.category = category;
		this.price = price;
		productMap.put(this.id, this);
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}
}
