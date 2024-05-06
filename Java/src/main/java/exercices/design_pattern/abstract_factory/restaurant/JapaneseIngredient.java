package exercices.design_pattern.abstract_factory.restaurant;

public class JapaneseIngredient extends Ingredient
{
	@Override
	protected void prepare()
	{
		System.out.println("Preparing Japanese ingredient");
	}
}
