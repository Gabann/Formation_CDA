package jdbc.tp_recipe.dao;

import jdbc.tp_recipe.entity.Step;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class StepDAO extends BaseDAO<Step>
{
	public StepDAO(Connection connection)
	{
		super(connection);
	}

	@Override
	public Step create(Step element) throws SQLException
	{
		request = "INSERT INTO Step (description, id_recipe) VALUES (?, ?)";
		preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, element.getDescription());
		preparedStatement.setInt(2, element.getIdRecipe());
		int affectedRows = preparedStatement.executeUpdate();

		if (affectedRows == 0)
		{
			throw new SQLException("Creating step failed, no rows affected.");
		}

		try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys())
		{
			if (generatedKeys.next())
			{
				element.setId(generatedKeys.getInt(1));
			}
			else
			{
				throw new SQLException("Creating step failed, no ID obtained.");
			}
		}

		connection.commit();
		return element;
	}

	@Override
	public Step update(Step element) throws SQLException
	{
		return null;
	}

	@Override
	public boolean delete(Step element) throws SQLException
	{
		return false;
	}

	@Override
	public Step getById(int id) throws SQLException
	{
		return null;
	}

	@Override
	public List<Step> get() throws SQLException
	{
		return List.of();
	}
}
