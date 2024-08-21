package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.entity.Product;
import org.example.repository.ProductRepository;

import java.util.List;

@ApplicationScoped
public class ProductService
{
	@Inject
	ProductRepository repository;

	public List<Product> getAll()
	{
		return repository.listAll();
	}

	public Product getById(Long id)
	{
		return repository.findById(id);
	}

	@Transactional
	public boolean deleteById(Long id)
	{
		if (repository.findById(id) != null)
		{
			repository.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Transactional
	public void create(Product product)
	{
		repository.persist(product);
	}

	@Transactional
	public boolean updateById(Long id, Product newProduct)
	{
		Product existingProduct = repository.findById(id);
		if (existingProduct != null)
		{
			return false;
		}

		existingProduct.setDescription(newProduct.getDescription());
		existingProduct.setPrice(newProduct.getPrice());
		existingProduct.setName(newProduct.getName());
		repository.persist(existingProduct);
		return true;
	}
}
