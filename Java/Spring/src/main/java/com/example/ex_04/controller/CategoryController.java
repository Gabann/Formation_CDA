package com.example.ex_04.controller;

import com.example.ex_04.model.Category;
import com.example.ex_04.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController
{
	private final CategoryService categoryService;

	CategoryController(CategoryService categoryService)
	{
		this.categoryService = categoryService;
	}

	@PostMapping("cooking/deleteCategory/{id}")
	public String deleteById(@PathVariable long id)
	{
		categoryService.deleteById(id);
		return "redirect:/cooking/getAllCategories";
	}

	@GetMapping("cooking/addCategory")
	public String addCategory(Model model)
	{
		model.addAttribute("category", new Category());
		return "ex_04/addCategory";
	}

	@PostMapping("cooking/addCategory")
	public String addCategory(@ModelAttribute("category") Category category)
	{
		return "index";
	}

	@GetMapping("cooking/getAllCategories")
	public String getAllCategories(Model model)
	{
		model.addAttribute("categoryList", categoryService.getAll());
		return "ex_04/categoryList";
	}

	@GetMapping("cooking/editCategory")
	public String editCategory(@RequestParam("categoryId") Long categoryId, Model model)
	{
		model.addAttribute("category", categoryService.getById(categoryId));
		return "ex_04/editCategory";
	}

	@PostMapping("cooking/editCategory")
	public String editCategory(@ModelAttribute("category") Category category)
	{
		categoryService.replaceById(category.getId(), category);
		return "redirect:/cooking/getAllCategories";
	}


}
