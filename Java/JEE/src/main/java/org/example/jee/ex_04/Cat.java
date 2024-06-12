package org.example.jee.ex_04;

import java.time.LocalDate;

public class Cat
{
	String name;
	String species;
	String favoriteMeal;
	LocalDate birthDate;

	public Cat(String name, String species, String favoriteMeal, LocalDate birthDate)
	{
		this.name = name;
		this.species = species;
		this.favoriteMeal = favoriteMeal;
		this.birthDate = birthDate;
	}

	public String getName()
	{
		return name;
	}

	public String getSpecies()
	{
		return species;
	}

	public String getFavoriteMeal()
	{
		return favoriteMeal;
	}

	public LocalDate getBirthDate()
	{
		return birthDate;
	}
}
