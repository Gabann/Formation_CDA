package jdbc.tp_recipe.dao;

import jdbc.tp_recipe.entity.Recipe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class RecipeDAO extends BaseDAO<Recipe>
{
	public RecipeDAO(Connection connection)
	{
		super(connection);
	}

	@Override
	public Recipe create(Recipe element) throws SQLException
	{
		request = "INSERT INTO Recipe (name, prepTime, prepCuisson, difficulty, id_categorie) VALUES (?, ?, ?, ?, ?)";
		preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, element.getName());
		preparedStatement.setInt(2, element.getPrepTime());
		preparedStatement.setInt(3, element.getPrepCuisson());
		preparedStatement.setInt(4, element.getDifficulty());
		preparedStatement.setInt(5, element.getIdCategory());
		int affectedRows = preparedStatement.executeUpdate();

		if (affectedRows == 0)
		{
			throw new SQLException("Creating recipe failed, no rows affected.");
		}

		try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys())
		{
			if (generatedKeys.next())
			{
				element.setId(generatedKeys.getInt(1));
			}
			else
			{
				throw new SQLException("Creating recipe failed, no ID obtained.");
			}
		}

		connection.commit();
		return element;
	}

	@Override
	public Recipe update(Recipe element) throws SQLException
	{
		return null;
	}

	@Override
	public boolean delete(Recipe element) throws SQLException
	{
		return false;
	}

	@Override
	public Recipe getById(int id) throws SQLException
	{
		return null;
	}

	@Override
	public List<Recipe> get() throws SQLException
	{
		return List.of();
	}
}
