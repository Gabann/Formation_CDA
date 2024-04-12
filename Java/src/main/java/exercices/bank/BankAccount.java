package exercices.bank;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount
{
	double balance;
	Client client;

	List<Operation> operationList = new ArrayList<>();

	protected BankAccount(Client client)
	{
		this.client = client;
		client.addBankAccount(this);
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
		if (amount <= 0)
		{
			System.out.println("You can't deposit a null or negative value");
			return;
		}

		operationList.add(new Operation(amount, OperationType.DEPOSIT));
		setBalance(getBalance() + amount);
	}

	public void withDraw(double amount)
	{
		if (amount <= 0)
		{
			System.out.println("You can't withdraw a null or negative value");
			return;
		}

		if (balance < amount)
		{
			System.out.printf("You only have %.2f and tried to withdraw %.2f %n", getBalance(), amount);
			return;
		}

		operationList.add(new Operation(amount, OperationType.WITHDRAWAL));
		setBalance(getBalance() - amount);
	}
}
