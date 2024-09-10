package cda.tpproductservice.controller;

import cda.tpproductservice.entity.Product;
import cda.tpproductservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController
{
	private final ProductService service;

	public ProductController(ProductService service)
	{
		this.service = service;
	}

	@GetMapping("/all")
	public List<Product> getAllProducts()
	{
		return service.getAll();
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id)
	{
		return service.getById(id);
	}

	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product)
	{
		return service.create(product);
	}

	@DeleteMapping("/{id}")
	public boolean deleteProduct(@PathVariable Long id)
	{
		return service.deleteById(id);
	}

	@PutMapping("/{id}")
	public boolean updateProduct(@PathVariable Long id, @RequestBody Product product)
	{
		return service.updateById(id, product);
	}
}
