package jpa.tp_computer;

import jpa.tp_computer.entity.Address;
import jpa.tp_computer.entity.Computer;
import jpa.tp_computer.entity.Processor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main
{
	public static void main(String[] args)
	{
		EntityManager entityManager = Persistence.createEntityManagerFactory("jpa_demo").createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		Processor processor = new Processor.Builder().brand("Intel").model("i7-13700k").build();

		entityManager.persist(processor);

		Address address = new Address.Builder().address("127.0.0.1").addressType("ip").build();
		Computer computer = new Computer.Builder().cpu(processor).gpu("3070TI").ram(32).ipAddress(address).build();
		Computer computer2 = new Computer.Builder().cpu(processor).gpu("3070TI").ram(32).ipAddress(address).build();

		entityManager.persist(computer);
		entityManager.persist(computer2);

		transaction.commit();
	}
}
