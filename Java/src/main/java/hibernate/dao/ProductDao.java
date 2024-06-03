package hibernate.dao;

import hibernate.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class ProductDao extends AbstractDao<Product>
{
	public ProductDao(SessionFactory sessionFactory)
	{
		super(sessionFactory, Product.class);
	}

	public List<Product> getPriceGreaterThan(double price)
	{
		Session session = sessionFactory.openSession();
		Query<Product> query = session.createNamedQuery("Product.findByPriceGreaterThan", Product.class);
		query.setParameter("price", price);
		var results = query.getResultList();
		session.close();
		return results;
	}

	public List<Product> getBetweenTwoDates(LocalDate startDate, LocalDate endDate)
	{
		Session session = sessionFactory.openSession();
		Query<Product> query = session.createNamedQuery("Product.findByPurchaseDateBetween", Product.class);
		query.setParameter("purchaseDateStart", startDate);
		query.setParameter("purchaseDateEnd", endDate);
		var results = query.getResultList();
		session.close();
		return results;
	}

	public List<Object> getStockLessThan(int amount)
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select id,reference from Product where stock < :stock");
		query.setParameter("stock", amount);
		List results = query.getResultList();

		session.close();

		return results;
	}

	public List<Integer> getStockByBrand(String brand)
	{
		Session session = sessionFactory.openSession();
		Query<Integer> query = session.createNamedQuery("Product.findStockByBrand", Integer.class);
		query.setParameter("brand", brand);
		List<Integer> results = query.getResultList();
		session.close();
		return results;
	}

	public double getAveragePrice()
	{
		Session session = sessionFactory.openSession();
		Query<Double> query = session.createNamedQuery("Product.findAveragePrice", Double.class);
		double result = query.getSingleResult();
		session.close();
		return result;
	}

	public List<Product> getByBrand(String brand)
	{
		Session session = sessionFactory.openSession();
		Query<Product> query = session.createNamedQuery("Product.findByBrand", Product.class);
		query.setParameter("brand", brand);
		List<Product> results = query.getResultList();
		session.close();
		return results;
	}

	public void deleteByBrand(String brand)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createNamedQuery("Product.deleteByBrand");
		query.setParameter("brand", brand);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

	public List<Product> getWithAverageScoreGreaterThan(double value)
	{
		Session session = sessionFactory.openSession();
		Query<Product> query = session.createQuery("select p" +
				" from Product p " +
				" join p.comments c" +
				" group by p" +
				" having avg(c.score) >= :value", Product.class);
		query.setParameter("value", value);
		List<Product> results = query.getResultList();
		session.close();
		return results;
	}
}
