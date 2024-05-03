package exercices.restaurant;

public class ItalianKitchenFactory extends KitchenFactory
{
	@Override
	Ingredient createIngredient()
	{
		return new ItalianIngredient();
	}

	@Override
	CookingUtensil createUtensil()
	{
		return new ItalianUtensil();
	}

	@Override
	Dish createDish()
	{
		return new ItalianDish();
	}
}
