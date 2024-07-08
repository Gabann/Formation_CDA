package com.example.mvc.ex_04.service;

import com.example.mvc.ex_04.model.Category;
import com.example.mvc.ex_04.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService
{
	RecipeService()
	{
		Recipe recipe1 = new Recipe("recipe1", List.of("ingredient 1", "ingredient 2"), "recipe1", new Category("recipe1", "recipe1"));
		Recipe recipe2 = new Recipe("recipe2", List.of("ingredient 1", "ingredient 2"), "recipe2", new Category("recipe2", "recipe2"));
	}

	public List<Recipe> getAll()
	{
		return Recipe.recipeMap.values()
				.stream()
				.toList();
	}

	public Recipe getById(Long id)
	{
		return Recipe.recipeMap.get(id);
	}

	public void deleteById(Long id)
	{
		Recipe.recipeMap.remove(id);
	}

	public void replaceById(Long id, Recipe newRecipe)
	{
		Recipe.recipeMap.put(id, newRecipe);
	}
}
