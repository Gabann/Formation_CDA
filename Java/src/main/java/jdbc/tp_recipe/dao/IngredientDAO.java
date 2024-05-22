package jdbc.tp_recipe.dao;


import jdbc.tp_recipe.entity.Ingredient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class IngredientDAO extends BaseDAO<Ingredient>
{
	public IngredientDAO(Connection connection)
	{
		super(connection);
	}

	@Override
	public Ingredient create(Ingredient element) throws SQLException
	{
		request = "INSERT INTO ingredient (name) VALUES (?)";
		preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, element.getName());
		int affectedRows = preparedStatement.executeUpdate();

		if (affectedRows == 0)
		{
			throw new SQLException("Creating ingredient failed, no rows affected.");
		}

		try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys())
		{
			if (generatedKeys.next())
			{
				element.setId(generatedKeys.getInt(1));
			}
			else
			{
				throw new SQLException("Creating ingredient failed, no ID obtained.");
			}
		}

		connection.commit();
		return element;
	}

	@Override
	public Ingredient update(Ingredient element) throws SQLException
	{
		return null;
	}

	@Override
	public boolean delete(Ingredient element) throws SQLException
	{
		return false;
	}

	@Override
	public Ingredient getById(int id) throws SQLException
	{
		return null;
	}

	@Override
	public List<Ingredient> get() throws SQLException
	{
		return List.of();
	}
}
