package hibernate.ex_01;


import hibernate.ex_01.dao.AbstractDao;
import hibernate.ex_01.entity.Product;
import hibernate.ex_01.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Scanner scanner = new Scanner(System.in);

		var productDAO = new AbstractDao<Product>(sessionFactory);


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
		System.out.println(productDAO.findById(Product.class, 2L));

		//Supprimer le produit dont id = 3
		productDAO.deleteById(Product.class, 3L);

		//Modifier les informations du produit dont id = 1,
		Product product1 = productDAO.findById(Product.class, 1L);
		if (product1 != null)
		{
			product1.setPrice(999999);
			productDAO.saveOrUpdate(product1);
		}

		//Afficher la totalité des produits
		System.out.println(productDAO.findAll(Product.class));

		//Afficher la liste des produits dont le prix est supérieur à 100 euros
		Query<Product> query1 = session.createNamedQuery("Product.findByPriceGreaterThan", Product.class);
		query1.setParameter("price", 1.0);
		System.out.println(query1.getResultList());

		//Afficher la liste des produits achetés entre deux dates.
		product1.setPurchaseDate(LocalDate.now().minusDays(5));
		productDAO.saveOrUpdate(product1);

		Query<Product> query2 = session.createNamedQuery("Product.findByPurchaseDateBetween", Product.class);
		query2.setParameter("purchaseDate", LocalDate.now().minusDays(100));
		query2.setParameter("purchaseDateEnd", LocalDate.now().minusDays(1));
		System.out.println(query2.getResultList());


		//Afficher la liste des produits commandés entre deux dates lus au clavier.
//		Query<Product> query3 = session.createNamedQuery("Product.findByPurchaseDateBetween", Product.class);
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
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
//
//		query3.setParameter("purchaseDate", startDate);
//		query3.setParameter("purchaseDateEnd", endDate);
//		System.out.println(query3.getResultList());


		//Retourner les numéros et reference des articles dont le stock est inférieur à une valeur lue au clavier.
		product1.setStock(3);
		productDAO.saveOrUpdate(product1);

		System.out.println("Enter stock amount");
		int stockInput = scanner.nextInt();

		Query<Product> query4 = session.createQuery("select id,reference from Product where stock < :stock");
		query4.setParameter("stock", stockInput);
		List result = query4.getResultList();

		for (Object o : result)
		{
			Object[] res = (Object[]) o;
			System.out.println("id: " + res[0] + " reference: " + res[1]);
		}
	}
}
