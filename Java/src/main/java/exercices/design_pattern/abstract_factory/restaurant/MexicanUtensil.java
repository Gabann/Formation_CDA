package exercices.design_pattern.abstract_factory.restaurant;

public class MexicanUtensil extends CookingUtensil
{
	@Override
	void use()
	{
		System.out.println("Using Mexican utensil");
	}
}
