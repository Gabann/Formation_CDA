package exercices.pizza;

public class Main
{
	public static void main(String[] args)
	{
		Pizza pizza = new Pizza.PizzaBuilder()
				.cheese(pizzaCheese.CHEDDAR)
				.dough(pizzaDough.THIN)
				.sauce(pizzaSauce.CREAM)
				.size(pizzaSize.LARGE)
				.topping(pizzaTopping.HAM, pizzaTopping.MUSHROOMS)
				.build();

		System.out.println(pizza);
	}
}
