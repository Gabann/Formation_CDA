package exercices.restaurant;

public class Restaurant
{
	public void serveFood(KitchenFactory kitchenFactory)
	{
		Ingredient ingredient = kitchenFactory.createIngredient();
		CookingUtensil utensil = kitchenFactory.createUtensil();
		Dish dish = kitchenFactory.createDish();

		dish.serve();
		utensil.use();
		ingredient.prepare();
	}
}
