package exercices.design_pattern.abstract_factory.restaurant;

public class ItalianUtensil extends CookingUtensil
{
	@Override
	void use()
	{
		System.out.println("Using Italian utensil");
	}
}
