package com.example.mvc.ex_04.model;

import java.util.HashMap;
import java.util.Map;

public class Category
{
	public static Map<Long, Category> categoryMap = new HashMap<>();
	private static Long categoryCount = 0L;
	private final Long id;
	String name;
	String description;

	public Category()
	{
		this.id = ++categoryCount;
		categoryMap.put(this.id, this);
	}

	public Category(String name, String description)
	{
		this.id = ++categoryCount;
		this.name = name;
		this.description = description;

		categoryMap.put(this.id, this);
	}

	public Long getId()
	{
		return id;
	}

	@Override
	public String toString()
	{
		return "Category{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
