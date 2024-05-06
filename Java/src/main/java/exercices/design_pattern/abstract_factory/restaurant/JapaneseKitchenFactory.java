package exercices.design_pattern.abstract_factory.restaurant;

public class JapaneseKitchenFactory extends KitchenFactory
{
	@Override
	Ingredient createIngredient()
	{
		return new JapaneseIngredient();
	}

	@Override
	CookingUtensil createUtensil()
	{
		return new JapaneseUtensil();
	}

	@Override
	Dish createDish()
	{
		return new JapaneseDish();
	}
}
