package exercices.restaurant;

public class MexicanIngredient extends Ingredient
{
	@Override
	protected void prepare()
	{
		System.out.println("Preparing Mexican ingredient");
	}
}
