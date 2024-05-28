package algo.design_pattern.builder.pizza;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

enum pizzaSize
{
	SMALL,
	MEDIUM,
	LARGE
}

enum pizzaDough
{
	CLASSIC,
	THIN,
	THICK
}

enum pizzaCheese
{
	MOZZARELLA,
	CHEDDAR,
}

enum pizzaTopping
{
	HAM,
	PEPPERONI,
	MUSHROOMS,
	BELL_PEPPER
}

enum pizzaSauce
{
	TOMATO,
	CREAM,
	BARBECUE
}


public class Pizza
{
	pizzaSize pizzaSize;
	pizzaDough pizzaDough;
	pizzaCheese pizzaCheese;
	Set<pizzaTopping> pizzaTopping;
	pizzaSauce pizzaSauce;

	private Pizza(PizzaBuilder builder)
	{
		this.pizzaCheese = builder.pizzaCheese;
		this.pizzaDough = builder.pizzaDough;
		this.pizzaSize = builder.pizzaSize;
		this.pizzaSauce = builder.pizzaSauce;
		this.pizzaTopping = builder.pizzaTopping;
	}

	@Override
	public String toString()
	{
		return "Pizza{" +
				"pizzaSize=" + pizzaSize +
				", pizzaDough=" + pizzaDough +
				", pizzaCheese=" + pizzaCheese +
				", pizzaTopping=" + pizzaTopping +
				", pizzaSauce=" + pizzaSauce +
				'}';
	}

	public static class PizzaBuilder
	{
		private final Set<pizzaTopping> pizzaTopping = new HashSet<>();
		private pizzaSize pizzaSize;
		private pizzaDough pizzaDough;
		private pizzaCheese pizzaCheese;
		private pizzaSauce pizzaSauce;

		public Pizza build()
		{
			return new Pizza(this);
		}

		public PizzaBuilder size(pizzaSize pizzaSize)
		{
			this.pizzaSize = pizzaSize;
			return this;
		}

		public PizzaBuilder dough(pizzaDough pizzaDough)
		{
			this.pizzaDough = pizzaDough;
			return this;
		}

		public PizzaBuilder cheese(pizzaCheese pizzaCheese)
		{
			this.pizzaCheese = pizzaCheese;
			return this;
		}

		public PizzaBuilder topping(pizzaTopping... pizzaTopping)
		{
			Collections.addAll(this.pizzaTopping, pizzaTopping);
			return this;
		}

		public PizzaBuilder sauce(pizzaSauce pizzaSauce)
		{
			this.pizzaSauce = pizzaSauce;
			return this;
		}
	}
}
