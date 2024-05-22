package jdbc.tp_zoo.dao;

import jdbc.tp_zoo.entity.Animal;
import jdbc.tp_zoo.entity.CaretakerAnimal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CaretakerAnimalDAO extends BaseDAO<CaretakerAnimal>
{
	public CaretakerAnimalDAO(Connection connection)
	{
		super(connection);
	}

	@Override
	public CaretakerAnimal create(CaretakerAnimal element) throws SQLException
	{
		try
		{
			request = "INSERT INTO caretaker_animal (caretaker_id,animal_id) VALUE (?,?)";
			preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, element.getIdCaretaker());
			preparedStatement.setInt(2, element.getIdAnimal());
			int nbrow = preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();

			if (nbrow != 1)
			{
				throw new SQLException();
			}
			if (resultSet.next())
			{
				element.setId(resultSet.getInt(1));
			}
			connection.commit();
			return element;
		} catch (SQLException e)
		{
			connection.rollback();
			return null;
		}
	}

	@Override
	public CaretakerAnimal update(CaretakerAnimal element) throws SQLException
	{
		return null;
	}

	@Override
	public boolean delete(CaretakerAnimal element) throws SQLException
	{
		return false;
	}

	@Override
	public CaretakerAnimal getById(int id) throws SQLException
	{
		return null;
	}

	@Override
	public List<CaretakerAnimal> get() throws SQLException
	{
		return List.of();
	}

	public List<Animal> getAllAnimalByCaretakerId(int id) throws SQLException
	{
		List<Animal> animals = new ArrayList<>();
		request =
				"SELECT DISTINCT animal.name, animal.description, animal.age " +
						"FROM animal " +
						"INNER JOIN caretaker_animal " +
						"WHERE caretaker_id = ?";
		preparedStatement = connection.prepareStatement(request);
		preparedStatement.setInt(1, id);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next())
		{
			animals.add(new Animal.Builder().name(resultSet.getString("name")).age(resultSet.getInt("age"))
					.description(resultSet.getString("description")).build());
//			commandes.add(Commande.builder().id(resultSet.getInt("commandeId"))
//					.prix(resultSet.getFloat("commandePrix"))
//					.quantite(resultSet.getInt("commandeQuantite"))
//					.plante(planteDAO.get(resultSet.getInt("commandePlanteId")))
//					.build());
		}
		return animals;
	}
}
