package jpa;

import jpa.entity.Test;

import javax.persistence.*;
import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
		EntityManager em = emf.createEntityManager();
		var transaction = em.getTransaction();
		transaction.begin();

		var test = new Test.Builder().name("test name").build();
		em.persist(test);

		transaction.commit();

		try
		{
			//Get by id
			var testFound = em.getReference(Test.class, 99);
			if (testFound != null)
			{
				System.out.println(testFound);
			}
		} catch (EntityNotFoundException e)
		{
			System.out.println(e.getMessage());
		}

		try
		{
			Query query = em.createQuery("select t from Test t where t.id = 99");
			var testFoundByQuery = (Test) query.getSingleResult();
			System.out.println(testFoundByQuery);
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}

		try
		{
			Query query1 = em.createQuery("select t from Test t");
			List testList = query1.getResultList();

			for (Object testInList : testList)
			{
				System.out.println("from list : " + testInList);
			}
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}

		try
		{
			transaction.begin();

			Query query1 = em.createQuery("delete from Test t where t.id = 2");
			int deletedCount = query1.executeUpdate();
			System.out.println("Deleted count: " + deletedCount);

			transaction.commit();
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}


		em.close();
		emf.close();
	}
}
