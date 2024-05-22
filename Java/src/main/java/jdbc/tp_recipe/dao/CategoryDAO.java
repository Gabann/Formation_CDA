package jdbc.tp_recipe.dao;

import jdbc.tp_recipe.entity.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CategoryDAO extends BaseDAO<Category>
{
	public CategoryDAO(Connection connection)
	{
		super(connection);
	}

	@Override
	public Category create(Category element) throws SQLException
	{
		request = "INSERT INTO categorie (name) VALUES (?)";
		preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, element.getName());
		int affectedRows = preparedStatement.executeUpdate();

		if (affectedRows == 0)
		{
			throw new SQLException("Creating category failed, no rows affected.");
		}

		try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys())
		{
			if (generatedKeys.next())
			{
				element.setId(generatedKeys.getInt(1));
			}
			else
			{
				throw new SQLException("Creating category failed, no ID obtained.");
			}
		}

		connection.commit();
		return element;
	}

	@Override
	public Category update(Category element) throws SQLException
	{
		return null;
	}

	@Override
	public boolean delete(Category element) throws SQLException
	{
		return false;
	}

	@Override
	public Category getById(int id) throws SQLException
	{
		return null;
	}

	@Override
	public List<Category> get() throws SQLException
	{
		return List.of();
	}
}
