package hibernate.ex_01;

import hibernate.ex_01.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDateTime;

public class Main
{
	public static void main(String[] args)
	{
		StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();


		session.getTransaction().begin();

		for (int i = 0; i < 5; i++)
		{
			Product product = new Product.Builder().brand("brand").price(10).stock(99).purchaseDate(LocalDateTime.now()).build();
			session.save(product);
		}

		Product product2 = session.get(Product.class, 2L);
		if (product2 != null)
		{
			System.out.println(product2);
		}

		Product product3 = session.get(Product.class, 3L);
		if (product3 != null)
		{
			session.delete(product3);
		}

		Product product1 = session.get(Product.class, 1L);
		if (product1 != null)
		{
			product1.setPrice(9999);
			session.update(product1);
		}


		session.getTransaction().commit();

		session.close();
		sessionFactory.close();
	}
}
