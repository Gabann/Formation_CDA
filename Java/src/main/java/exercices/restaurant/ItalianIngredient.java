package exercices.restaurant;

public class ItalianIngredient extends Ingredient
{
	@Override
	protected void prepare()
	{
		System.out.println("Preparing Italian ingredient");
	}
}
