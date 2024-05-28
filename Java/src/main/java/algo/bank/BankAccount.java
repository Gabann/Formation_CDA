package algo.bank;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount
{
	double maxOverdraft = -200;
	double balance = 0;
	Client client;

	List<Operation> operationList = new ArrayList<>();

	protected BankAccount(Client client)
	{
		this(client, 0);
	}

	protected BankAccount(Client client, double initialBalance)
	{
		this.client = client;
		deposit(initialBalance);
		client.addBankAccount(this);
	}

	protected double getBalance()
	{
		return balance;
	}

	public List<Operation> getOperationList()
	{
		return operationList;
	}

	private void setBalance(double balance, Operation.OperationType operationType)
	{
		operationList.add(new Operation(Math.abs(this.balance - balance), operationType));
		this.balance = balance;
	}

	public void deposit(double amount)
	{
		if (amount <= 0)
		{
			System.out.println("You can't deposit a null or negative value");
			return;
		}

		setBalance(getBalance() + amount, Operation.OperationType.DEPOSIT);
	}

	public void withdraw(double amount)
	{
		if (amount == 0)
		{
			System.out.println("You can't withdraw an amount of 0");
			return;
		}

		if (balance - amount < maxOverdraft)
		{
			System.out.printf("This withdraw would make you have %.2f but you're only allowed to have an overdraft of %.2f %n",
					balance - amount, maxOverdraft);
			return;
		}

		setBalance(getBalance() - amount, Operation.OperationType.WITHDRAWAL);
	}
}
