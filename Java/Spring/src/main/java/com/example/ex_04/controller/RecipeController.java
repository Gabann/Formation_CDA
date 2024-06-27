package com.example.ex_04.controller;

import com.example.ex_04.model.Category;
import com.example.ex_04.model.Recipe;
import com.example.ex_04.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class RecipeController
{
	private final RecipeService recipeService;

	RecipeController(RecipeService recipeService)
	{
		this.recipeService = recipeService;
	}

	@GetMapping("cooking/getAllRecipes")
	public String getAllRecipes(Model model)
	{
		model.addAttribute("recipeList", recipeService.getAll());
		return "ex_04/recipeList";
	}

	@GetMapping("cooking/addRecipe")
	public String addRecipe(Model model)
	{
		model.addAttribute("recipe", new Recipe());
		model.addAttribute("categoryList", Category.categoryMap.values());
		return "ex_04/addRecipe";
	}

	@PostMapping("cooking/addRecipe")
	public String addRecipe(@ModelAttribute("recipe") Recipe recipe,
	                        @RequestParam("ingredients") String ingredients,
	                        @RequestParam("category") String category)
	{
		List<String> ingredientList = Arrays.stream(ingredients.split(",")).toList();
		recipe.setIngredientsList(ingredientList);
		System.out.println(category);
		System.out.println(recipe);
		System.out.println(Recipe.recipeMap);
		return "index";
	}

	@PostMapping("cooking/deleteRecipe/{id}")
	public String deleteById(@PathVariable long id)
	{
		recipeService.deleteById(id);
		return "redirect:/cooking/getAllRecipes";
	}

	@GetMapping("cooking/editRecipe/{id}")
	public String editRecipe(@PathVariable() Long id, Model model)
	{
		model.addAttribute("recipe", recipeService.getById(id));
		return "ex_04/editRecipe";
	}

	@PostMapping("cooking/editRecipe")
	public String editRecipe(@ModelAttribute("recipe") Recipe recipe)
	{
		recipeService.replaceById(recipe.getId(), recipe);
		return "redirect:/cooking/getAllRecipes";
	}
}
