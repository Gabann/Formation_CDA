package com.example.ex_02.controller;

import com.example.ex_02.model.Product;
import com.example.ex_02.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController
{
	private final ProductService productService;

	public ProductController(ProductService productService)
	{
		this.productService = productService;
	}

	@GetMapping("/product/getAll")
	@ResponseBody
	public List<Product> allProduct()
	{
		return productService.getAll();
	}

	@GetMapping("/product/id/{productId}")
	@ResponseBody
	public Product byId(@PathVariable("productId") Long productId)
	{
		return productService.getById(productId);
	}

	@GetMapping("product/category/{productCategory}")
	@ResponseBody
	public List<Product> byCategory(@PathVariable("productCategory") String productCategory)
	{
		return productService.getByCategory(productCategory);
	}

	@GetMapping("product/maxPrice/{maxPrice}")
	@ResponseBody
	public List<Product> byMaxPrice(@PathVariable("maxPrice") Double maxPrice)
	{
		return productService.getByMaxPrice(maxPrice);
	}
}
