package algo.design_pattern.abstract_factory.restaurant;

public class MexicanKitchenFactory extends KitchenFactory
{
	@Override
	Ingredient createIngredient()
	{
		return new MexicanIngredient();
	}

	@Override
	CookingUtensil createUtensil()
	{
		return new MexicanUtensil();
	}

	@Override
	Dish createDish()
	{
		return new MexicanDish();
	}
}
