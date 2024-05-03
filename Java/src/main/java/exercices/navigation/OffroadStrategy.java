package exercices.navigation;

public class OffroadStrategy implements NavigationStrategy
{
	@Override
	public void useNavigation(String destination)
	{
		System.out.println("Offroad");
	}
}
