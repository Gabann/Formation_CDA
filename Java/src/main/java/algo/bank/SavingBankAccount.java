package algo.bank;

public class SavingBankAccount extends BankAccount
{
	double yearlyInterestPercent = 2.7;

	public SavingBankAccount(Client client)
	{
		super(client);
	}

	public SavingBankAccount(Client client, double yearlyInterestPercent)
	{
		super(client);
		this.yearlyInterestPercent = yearlyInterestPercent;
	}

	void applyInterest()
	{
		deposit(getBalance() * yearlyInterestPercent / 100);
	}
}
