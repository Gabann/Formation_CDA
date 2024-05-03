package exercices.tp;

import exercices.tp.entity.impl.Bike;
import exercices.tp.entity.impl.Computer;
import exercices.tp.entity.impl.Smartphone;
import exercices.tp.factory.ProductFactory;

import java.util.Scanner;

public class Ihm
{
	Scanner scanner = new Scanner(System.in);
	String[] products = {"Smartphone", "Computer", "Bike"};

	public void ihm()
	{

		System.out.println("Please select a product:");
		for (int i = 0; i < products.length; i++)
		{
			System.out.println(i + 1 + " - " + products[i]);
		}

		int userChoice = scanner.nextInt();

		switch (userChoice)
		{
			case 1 ->
			{
				System.out.println("You selected a Smartphone");
				System.out.println("Please enter the brand:");
				String brand = scanner.next();
				System.out.println("Please enter the model:");
				String model = scanner.next();
				System.out.println("Please enter the price:");
				int price = scanner.nextInt();
				Smartphone smartphone1 = new ProductFactory<Smartphone>().createProduct(new Smartphone.SmartphoneBuilder().brand(brand).model(
						model).price(price));
				System.out.println(smartphone1);
			}
			case 2 ->
			{
				System.out.println("You selected a Computer");
				System.out.println("Please enter the RAM:");
				int ram = scanner.nextInt();
				System.out.println("Please enter the processor:");
				String processor = scanner.next();
				System.out.println("Please enter the price:");
				int price = scanner.nextInt();
				Computer computer1 = new ProductFactory<Computer>().createProduct(new Computer.ComputerBuilder().ramGb(ram).processor(
						processor).price(price));
				System.out.println(computer1);
			}
			case 3 ->
			{
				System.out.println("You selected a Bike");
				System.out.println("Please enter the brand:");
				String brand = scanner.next();
				System.out.println("Please enter the wheel size:");
				int wheelSize = scanner.nextInt();
				System.out.println("Please enter the price:");
				int price = scanner.nextInt();
				Bike bike1 = new ProductFactory<Bike>().createProduct(new Bike.BikeBuilder().brand(brand).wheelSize(wheelSize).price(price));
				System.out.println(bike1);
			}
			default -> System.out.println("Invalid choice");
		}
	}
}
