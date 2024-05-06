package exercices.design_pattern.abstract_factory.restaurant;

public class JapaneseDish extends Dish
{
	@Override
	void serve()
	{
		System.out.println("Serving Japanese dish");
	}
}
