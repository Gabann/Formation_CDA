package algo.design_pattern.strategy.navigation;

public class RoadStrategy implements NavigationStrategy
{
	@Override
	public void useNavigation(String destination)
	{
		System.out.println("Road");
	}
}
