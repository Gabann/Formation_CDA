package cda.tpproductservice.service;

import cda.tpproductservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService
{
	private final ProductRepository repository;

	public ProductService(ProductRepository repository)
	{
		this.repository = repository;
	}
}
