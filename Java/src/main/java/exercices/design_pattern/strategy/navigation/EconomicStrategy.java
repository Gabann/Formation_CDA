package exercices.design_pattern.strategy.navigation;

public class EconomicStrategy implements NavigationStrategy
{
	@Override
	public void useNavigation(String destination)
	{
		System.out.println("Economic");
	}
}
