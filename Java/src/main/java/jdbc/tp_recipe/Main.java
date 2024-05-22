package jdbc.tp_recipe;

import jdbc.tp_recipe.dao.*;
import jdbc.tp_recipe.entity.Step;
import jdbc.tp_zoo.util.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;

public class Main
{

	public static void main(String[] args)
	{
		final Connection connection;
		final IngredientDAO ingredientDAO;
		final CategoryDAO categoryDAO;
		final CommentDAO commentDAO;
		final RecipeDAO recipeDAO;
		final StepDAO stepDAO;

		try
		{
			connection = DataBaseManager.getConnection();
			ingredientDAO = new IngredientDAO(connection);
			categoryDAO = new CategoryDAO(connection);
			commentDAO = new CommentDAO(connection);
			recipeDAO = new RecipeDAO(connection);
			stepDAO = new StepDAO(connection);

		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}

//		try
//		{
//			Ingredient ingredient = ingredientDAO.create(new Ingredient.Builder().name("name").build());
//			System.out.println("ingredient created" + ingredient);
//		} catch (SQLException e)
//		{
//			throw new RuntimeException(e);
//		}

//		try
//		{
//			Category category = categoryDAO.create(new Category.Builder().name("category").build());
//			System.out.println("category created" + category);
//		} catch (SQLException e)
//		{
//			throw new RuntimeException(e);
//		}

//		try
//		{
//			Recipe recipe =
//					recipeDAO.create(new Recipe.Builder().name("recipe").idCategory(1).difficulty(1).prepTime(15).prepCuisson(15).build());
//			System.out.println("recipe created" + recipe);
//		} catch (SQLException e)
//		{
//			throw new RuntimeException(e);
//		}

//		try
//		{
//			Comment comment = commentDAO.create(new Comment.Builder().description("comment").idRecipe(1).build());
//			System.out.println("comment created" + comment);
//		} catch (SQLException e)
//		{
//			throw new RuntimeException(e);
//		}


		try
		{
			Step step = stepDAO.create(new Step.Builder().description("step").idRecipe(1).build());
			System.out.println("step created" + step);
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}
}
