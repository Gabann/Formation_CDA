package exercices.restaurant;

public class Main
{
	public static void main(String[] args)
	{
		Restaurant restaurant = new Restaurant();

		restaurant.serveFood(new JapaneseKitchenFactory());
		restaurant.serveFood(new MexicanKitchenFactory());
		restaurant.serveFood(new ItalianKitchenFactory());
	}
}
