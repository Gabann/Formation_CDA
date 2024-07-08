package com.example.mvc.ex_02.service;

import com.example.mvc.ex_02.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
	public ProductService()
	{
		Product product1 = new Product("product1", "product1", 10.0);
		Product product2 = new Product("product2", "product2", 20.0);
	}

	public List<Product> getAll()
	{
		return Product.productMap.values().stream().toList();
	}

	public Product getById(Long id)
	{
		return Product.productMap.get(id);
	}

	public List<Product> getByName(String name)
	{
		return Product.productMap.values()
				.stream()
				.filter(product -> product.getName().equals(name))
				.toList();
	}

	public List<Product> getByCategory(String category)
	{
		return Product.productMap.values()
				.stream()
				.filter(product -> product.getCategory().equals(category))
				.toList();
	}

	public List<Product> getByMaxPrice(Double price)
	{
		return Product.productMap.values()
				.stream()
				.filter(product -> product.getPrice() <= price)
				.toList();
	}
}
