package algo.bank;

public class PaidBankAccount extends BankAccount
{
	double operationCost = 0.05;

	public PaidBankAccount(Client client)
	{
		super(client);
	}

	public PaidBankAccount(Client client, double operationCost)
	{
		super(client);
		this.operationCost = operationCost;
	}

	@Override
	public void deposit(double amount)
	{
		super.deposit(amount - operationCost);
	}

	@Override
	public void withdraw(double amount)
	{
		super.withdraw(amount - operationCost);
	}
}
