package jdbc.tp_zoo;

import jdbc.tp_zoo.dao.AnimalDAO;
import jdbc.tp_zoo.dao.CaretakerAnimalDAO;
import jdbc.tp_zoo.dao.MealDAO;
import jdbc.tp_zoo.entity.Animal;
import jdbc.tp_zoo.util.DataBaseManager;

import java.sql.Connection;
import java.util.List;

public class Main
{
	public static void main(String[] args)
	{

		final Connection connection;
		final AnimalDAO animalDAO;
		final MealDAO mealDAO;
		final CaretakerAnimalDAO caretakerAnimalDAO;

		try
		{
			connection = DataBaseManager.getConnection();
			animalDAO = new AnimalDAO(connection);
			mealDAO = new MealDAO(connection);
			caretakerAnimalDAO = new CaretakerAnimalDAO(connection);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}

//		try
//		{
////			Animal animal = animalDAO.getById(1);
//			Animal animal = animalDAO.getByName("name");
//			System.out.println(animal.getAge());
//		} catch (Exception e)
//		{
//			System.out.println("Something went wrong: " + e);
//		}


//		try
//		{
//			Animal animal = animalDAO.create(new Animal.Builder().name("st").age(5).build());
//			System.out.println("l'animal a ete cree" + animal);
//		} catch (SQLException e)
//		{
//			throw new RuntimeException(e);
//		}

//		try
//		{
//			Meal meal = mealDAO.create(new Meal.Builder().description("description").date(LocalDate.now()).animalId(1).build());
//			System.out.println("Meal was created" + meal);
//		} catch (SQLException e)
//		{
//			throw new RuntimeException(e);
//		}

//		try
//		{
//			CaretakerAnimal caretakerAnimal = caretakerAnimalDAO.create(new CaretakerAnimal.Builder().idAnimal(1).idCaretaker(1).build());
//			System.out.println("caretakerAnimal was created" + caretakerAnimal);
//		} catch (SQLException e)
//		{
//			throw new RuntimeException(e);
//		}

		try
		{
			List<Animal> animals = caretakerAnimalDAO.getAllAnimalByCaretakerId(1);
			animals.stream().forEach(animal -> System.out.println(animal.getName()));
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}
	}
}
