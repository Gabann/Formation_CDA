package algo.design_pattern.abstract_factory.restaurant;

public abstract class KitchenFactory
{
	abstract Ingredient createIngredient();

	abstract CookingUtensil createUtensil();

	abstract Dish createDish();
}
