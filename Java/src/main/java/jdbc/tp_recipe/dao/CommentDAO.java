package jdbc.tp_recipe.dao;

import jdbc.tp_recipe.entity.Comment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CommentDAO extends BaseDAO<Comment>
{
	public CommentDAO(Connection connection)
	{
		super(connection);
	}

	@Override
	public Comment create(Comment element) throws SQLException
	{
		request = "INSERT INTO commentaire (description, id_recipe) VALUES (?, ?)";
		preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, element.getDescription());
		preparedStatement.setInt(2, element.getIdRecipe());
		int affectedRows = preparedStatement.executeUpdate();

		if (affectedRows == 0)
		{
			throw new SQLException("Creating comment failed, no rows affected.");
		}

		try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys())
		{
			if (generatedKeys.next())
			{
				element.setId(generatedKeys.getInt(1));
			}
			else
			{
				throw new SQLException("Creating comment failed, no ID obtained.");
			}
		}

		connection.commit();
		return element;
	}

	@Override
	public Comment update(Comment element) throws SQLException
	{
		return null;
	}

	@Override
	public boolean delete(Comment element) throws SQLException
	{
		return false;
	}

	@Override
	public Comment getById(int id) throws SQLException
	{
		return null;
	}

	@Override
	public List<Comment> get() throws SQLException
	{
		return List.of();
	}
}
