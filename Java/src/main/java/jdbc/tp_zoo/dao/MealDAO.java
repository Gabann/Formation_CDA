package jdbc.tp_zoo.dao;

import jdbc.tp_zoo.entity.Meal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class MealDAO extends BaseDAO<Meal>
{
	public MealDAO(Connection connection)
	{
		super(connection);
	}

	@Override
	public Meal create(Meal meal) throws SQLException
	{
		try
		{
			request = "INSERT INTO meal (details, date, animal_id) VALUE (?,?,?)";
			preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, meal.getDescription());
			preparedStatement.setDate(2, Date.valueOf(meal.getDate()));
			preparedStatement.setInt(3, meal.getAnimalId());
			int nbrow = preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next())
			{
				meal.setId(resultSet.getInt(1));
			}
			if (nbrow != 1)
			{
				connection.rollback();
			}
			connection.commit();
			return meal;
		} catch (SQLException e)
		{
			connection.rollback();
			return null;
		}
	}

	@Override
	public Meal update(Meal element) throws SQLException
	{
		return null;
	}

	@Override
	public boolean delete(Meal element) throws SQLException
	{
		return false;
	}

	@Override
	public Meal getById(int id) throws SQLException
	{
		return null;
	}

	@Override
	public List<Meal> get() throws SQLException
	{
		return List.of();
	}
}
