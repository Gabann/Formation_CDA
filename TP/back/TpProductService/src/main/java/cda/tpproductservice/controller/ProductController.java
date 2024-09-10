package cda.tpproductservice.controller;

import cda.tpproductservice.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController
{
	private final ProductService service;

	public ProductController(ProductService service)
	{
		this.service = service;
	}
}
