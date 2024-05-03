package exercices.restaurant;

public abstract class KitchenFactory
{
	abstract Ingredient createIngredient();

	abstract CookingUtensil createUtensil();

	abstract Dish createDish();
}
