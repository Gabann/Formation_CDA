package com.example.mvc.ex_04.service;

import com.example.mvc.ex_04.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService
{
	CategoryService()
	{
		Category category1 = new Category("category1", "category1");
		Category category2 = new Category("category2", "category2");
	}

	public List<Category> getAll()
	{
		return Category.categoryMap.values()
				.stream()
				.toList();
	}

	public Category getById(Long id)
	{
		return Category.categoryMap.get(id);
	}

	public void deleteById(Long id)
	{
		Category.categoryMap.remove(id);
	}

	public void replaceById(Long id, Category newCategory)
	{
		Category.categoryMap.put(id, newCategory);
	}
}
