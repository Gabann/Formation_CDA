package hibernate.ex_01;


import hibernate.ex_01.dao.AbstractDao;
import hibernate.ex_01.dao.ProductDao;
import hibernate.ex_01.entity.Comment;
import hibernate.ex_01.entity.Image;
import hibernate.ex_01.entity.Product;
import hibernate.ex_01.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Scanner scanner = new Scanner(System.in);

		var productDAO = new ProductDao(sessionFactory);
		var commentDAO = new AbstractDao<>(sessionFactory, Comment.class);
		var imageDAO = new AbstractDao<>(sessionFactory, Image.class);


		//Créer cinq produits
		for (int i = 0; i < 5; i++)
		{
			Product product =
					new Product.Builder()
							.brand("brand")
							.price(10)
							.reference("reference")
							.stock(99)
							.purchaseDate(LocalDate.now())
							.build();

			productDAO.saveOrUpdate(product);
		}

		//Afficher les informations du produit dont id = 2
		System.out.println(productDAO.findById(2L));

		//Supprimer le produit dont id = 3
		productDAO.deleteById(3L);

		//Modifier les informations du produit dont id = 1,
		Product product1 = productDAO.findById(1L);
		if (product1 != null)
		{
			product1.setPrice(999999);
			productDAO.saveOrUpdate(product1);
		}

		//Afficher la totalité des produits
		System.out.println(productDAO.findAll());

		//Afficher la liste des produits dont le prix est supérieur à 100 euros
		System.out.println(productDAO.getPriceGreaterThan(100));

		//Afficher la liste des produits achetés entre deux dates.
		Product product2 = productDAO.findById(1L);

		if (product2 != null)
		{
			product2.setPurchaseDate(LocalDate.now().minusDays(5));
			productDAO.saveOrUpdate(product2);

			System.out.println(productDAO.getBetweenTwoDates(LocalDate.now().minusDays(100), LocalDate.now()));
		}


		//Afficher la liste des produits commandés entre deux dates lus au clavier.
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		System.out.println("Enter start date in format 'dd-MM-yyyy'");
//		String startDateString = scanner.nextLine();
//
//		LocalDate startDate = LocalDate.parse(startDateString, formatter);
//
//		System.out.println("Enter end date in format 'dd-MM-yyyy'");
//		String endDateString = scanner.nextLine();
//
//		LocalDate endDate = LocalDate.parse(endDateString, formatter);
//
//		System.out.println(productDAO.findBetweenTwoDates(startDate, endDate));


		//Retourner les numéros et reference des articles dont le stock est inférieur à une valeur lue au clavier.
		Product product3 = productDAO.findById(1L);

		if (product3 != null)
		{
			product3.setStock(3);
			productDAO.saveOrUpdate(product3);

			System.out.println("Enter stock amount");
			int stockInput = scanner.nextInt();

			System.out.println(productDAO.getStockLessThan(stockInput));
		}

		//Afficher la valeur du stock des produits d'une marque choisie.
		System.out.println(productDAO.getStockByBrand("brand"));

		//Calculer le prix moyen des produits.
		System.out.println(productDAO.getAveragePrice());

		//Récupérer la liste des produits d'une marque choisie.
		System.out.println(productDAO.getByBrand("brand"));

		//Supprimer les produits d'une marque choisie de la table produit.
//		productDAO.deleteByBrand("brand");

		//Adding image
		Image image = new Image.Builder().url("a.com").build();
		imageDAO.saveOrUpdate(image);

		Product product4 = productDAO.findById(1L);
		if (product4 != null)
		{
			product4.addImage(image);
			productDAO.saveOrUpdate(product4);
		}

		//Adding comment

		Product product5 = productDAO.findById(1L);
		if (product5 != null)
		{
			Comment comment = new Comment.Builder(product5).content("Comment").score(5).build();

			commentDAO.saveOrUpdate(comment);
		}

		//Afficher les produits ave une note de 4 ou plus.
		System.out.println(productDAO.getWithAverageScoreGreaterThan(4));
	}
}
