package hibernate.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil
{
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private HibernateUtil()
	{
	}

	private static SessionFactory buildSessionFactory()
	{
		try
		{
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
			throw new RuntimeException(e);
		}
	}

	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public static void close()
	{
		getSessionFactory().close();
	}
}
