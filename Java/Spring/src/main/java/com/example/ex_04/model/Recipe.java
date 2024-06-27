package com.example.ex_04.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe
{
	public static Map<Long, Recipe> recipeMap = new HashMap<>();
	private static Long recipeCount = 0L;
	private final Long id;
	String name;
	List<String> ingredientsList;
	String instructions;
	Category category;

	public Recipe()
	{
		this.id = ++recipeCount;
		recipeMap.put(this.id, this);
	}

	public Recipe(String name, List<String> ingredientsList, String instructions, Category category)
	{
		this.id = ++recipeCount;
		this.name = name;
		this.ingredientsList = ingredientsList;
		this.instructions = instructions;
		this.category = category;

		recipeMap.put(this.id, this);
	}

	public Long getId()
	{
		return id;
	}

	@Override
	public String toString()
	{
		return "Recipe{" +
				"id=" + id +
				", name='" + name + '\'' +
				", ingredientsList=" + ingredientsList +
				", instructions='" + instructions + '\'' +
				", category=" + category +
				'}';
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<String> getIngredientsList()
	{
		return ingredientsList;
	}

	public void setIngredientsList(List<String> ingredientsList)
	{
		this.ingredientsList = ingredientsList;
	}

	public String getInstructions()
	{
		return instructions;
	}

	public void setInstructions(String instructions)
	{
		this.instructions = instructions;
	}

	public Category getCategory()
	{
		return category;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}
}
