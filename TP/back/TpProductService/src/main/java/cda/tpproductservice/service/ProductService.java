package cda.tpproductservice.service;

import cda.tpproductservice.entity.Product;
import cda.tpproductservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
	private final ProductRepository repository;

	public ProductService(ProductRepository repository)
	{
		this.repository = repository;
	}

	public Product create(Product product)
	{
		return repository.save(product);
	}

	public List<Product> getAll()
	{
		return repository.findAll();
	}

	public boolean deleteById(Long id)
	{
		if (repository.findById(id).isPresent())
		{
			repository.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean updateById(Long id, Product newProduct)
	{
		Product existingProduct = repository.findById(id).orElse(null);
		if (existingProduct == null)
		{
			return false;
		}
		else
		{
			newProduct.setId(id);
			repository.save(newProduct);
			return true;
		}
	}

	public boolean decrementStockById(Long id)
	{
		return setStockById(id, getById(id).getStock() - 1);
	}

	public boolean setStockById(Long id, int stock)
	{
		Product product = repository.findById(id).orElse(null);
		if (product == null)
		{
			return false;
		}
		product.setStock(stock);
		repository.save(product);
		return true;
	}

	public Product getById(Long id)
	{
		return repository.findById(id).orElse(null);
	}

	public boolean decrementStockById(Long id, int quantity)
	{
		return setStockById(id, getById(id).getStock() - quantity);
	}
}
