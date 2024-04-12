package exercices;

import java.util.Scanner;

public class ArticleInventory
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		String[][] articlesArray = {
				{"Article1", "5"},
				{"Article2", "2"},
				{"Article3", "3"},
				{"Article4", "20"},
				{"Article5", "0"}
		};

		int menuInput;
		int articleIdInput;

		while (true)
		{
			System.out.println("Select an action");
			System.out.println("1. See article");
			System.out.println("2. Add article");
			System.out.println("3. Remove article");
			System.out.println("-1. Quit");

			menuInput = scanner.nextInt();

			if (menuInput == -1)
			{
				break;
			}

			switch (menuInput)
			{
				case 1:
				{
					do
					{
						System.out.println("Enter article id");
						articleIdInput = scanner.nextInt();
					} while (articleIdInput < 0 || articleIdInput > articlesArray.length - 1);

					System.out.printf("Article: %s%n", articlesArray[articleIdInput][0]);
					System.out.printf("Quantity: %s%n", articlesArray[articleIdInput][1]);
					break;
				}
				case 2:
				{
					do
					{
						System.out.println("Enter article id");
						articleIdInput = scanner.nextInt();
					} while (articleIdInput < 0 || articleIdInput > articlesArray.length - 1);

					int quantity = Integer.parseInt(articlesArray[articleIdInput][1]);
					quantity++;
					articlesArray[articleIdInput][1] = String.valueOf(quantity);

					System.out.printf("There is now %s of %s%n", articlesArray[articleIdInput][1], articlesArray[articleIdInput][0]);

					break;
				}
				case 3:
				{
					do
					{
						System.out.println("Enter article id");
						articleIdInput = scanner.nextInt();
					} while (articleIdInput < 0 || articleIdInput > articlesArray.length - 1);

					int quantity = Integer.parseInt(articlesArray[articleIdInput][1]);

					if (quantity > 0)
					{
						quantity--;
						articlesArray[articleIdInput][1] = String.valueOf(quantity);
					}
					else
					{
						System.out.println("You can't remove this article, theres is already 0 of it");
					}


					System.out.printf("There is now %s of %s%n", articlesArray[articleIdInput][1], articlesArray[articleIdInput][0]);

					break;
				}
				default:
				{
					System.out.println("Menu selection should be between 1 and 3");
				}
			}
		}

		System.out.print("Goodbye");
	}
}
