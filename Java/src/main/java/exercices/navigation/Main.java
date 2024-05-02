package exercices.navigation;

public class Main
{
	public static void main(String[] args)
	{
		NavigationSystem navigationSystem = new NavigationSystem();

		navigationSystem.setNavigationStrategy(new RoadStrategy());
		navigationSystem.navigate("Destination");

		navigationSystem.setNavigationStrategy(new OffroadStrategy());
		navigationSystem.navigate("Destination");
	}
}
