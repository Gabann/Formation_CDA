package exercices;

import java.util.List;

public abstract class BankAccount
{
	double balance;
	Client client;

	List<Operation> operationList;

	protected BankAccount(Client client)
	{
		this.client = client;
	}

	private double getBalance()
	{
		return balance;
	}

	private void setBalance(double balance)
	{
		this.balance = balance;
	}

	public void deposit(double amount)
	{
		if(amount <= 0)
		{
			System.out.println("You can't deposit a null or negative value");
			return;
		}

		setBalance(getBalance() + amount);
	}

	public void withDraw(double amount)
	{
		if(amount <= 0)
		{
			System.out.println("You can't withdraw a null or negative value");
			return;
		}

		if(balance < amount)
		{
			System.out.printf("You only have %.2f and tried to withdraw %.2f", getBalance(), amount);
			return;
		}

		setBalance(getBalance() - amount);
	}

}
