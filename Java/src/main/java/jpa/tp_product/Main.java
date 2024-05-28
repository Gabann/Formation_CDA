package jpa.tp_product;

import jpa.tp_product.entity.Test;
import jpa.tp_product.repository.GenericRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main
{
	public static void main(String[] args)
	{
		EntityManager entityManager = Persistence.createEntityManagerFactory("jpa_demo").createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		GenericRepository<Test> testRepository = new GenericRepository<>(entityManager, Test.class);

		transaction.begin();

		System.out.println(testRepository.findById(18));

		transaction.commit();
	}
}
