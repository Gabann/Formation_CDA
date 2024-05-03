package exercices.navigation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NavigationSystem
{
	private NavigationStrategy navigationStrategy;

	void navigate(String destination)
	{
		navigationStrategy.useNavigation(destination);
	}
}
