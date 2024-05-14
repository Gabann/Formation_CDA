package jdbc.tp_zoo.dao;

import jdbc.tp_zoo.entity.Animal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AnimalDAO extends BaseDAO<Animal>
{
	public AnimalDAO(Connection connection)
	{
		super(connection);
	}

	@Override
	public Animal create(Animal animal) throws SQLException
	{
		try
		{
			request = "INSERT INTO animal (name,race,description,habitat, age) VALUE (?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, animal.getName());
			preparedStatement.setString(2, animal.getRace());
			preparedStatement.setString(3, animal.getDescription());
			preparedStatement.setString(4, animal.getHabitat());
			preparedStatement.setInt(5, animal.getAge());
			int nbrow = preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next())
			{
				animal.setId(resultSet.getInt(1));
			}
			if (nbrow != 1)
			{
				connection.rollback();
			}
			connection.commit();
			return animal;
		} catch (SQLException e)
		{
			connection.rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Animal update(Animal element) throws SQLException
	{
		return null;
	}

	@Override
	public boolean delete(Animal element) throws SQLException
	{
		return false;
	}

	@Override
	public Animal getById(int id) throws SQLException
	{
		try
		{
			request = "SELECT * FROM animal WHERE id = ?";
			preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
			{
				return new Animal.Builder().age(resultSet.getInt("id"))
						.name(resultSet.getString("name"))
						.age(resultSet.getInt("age"))
						.description(resultSet.getString("description"))
						.habitat(resultSet.getString("habitat"))
						.race(resultSet.getString("race"))
						.build();
			}
		} catch (SQLException e)
		{
			connection.rollback();
			throw new RuntimeException(e);
		}
		return null;
	}

	public Animal getByName(String name) throws SQLException
	{
		try
		{
			request = "SELECT * FROM animal WHERE name = ?";
			preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
			{
				return new Animal.Builder().age(resultSet.getInt("id"))
						.name(resultSet.getString("name"))
						.age(resultSet.getInt("age"))
						.description(resultSet.getString("description"))
						.habitat(resultSet.getString("habitat"))
						.race(resultSet.getString("race"))
						.build();
			}
		} catch (SQLException e)
		{
			connection.rollback();
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public List<Animal> get() throws SQLException
	{
		return List.of();
	}
}
