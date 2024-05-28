package algo.bank;

public class Main
{
	public static void main(String[] args)
	{
		var client1 = new Client("Eda", "Clawthorne", "+33606060606");
		var account1 = new SavingBankAccount(client1);

		account1.deposit(100);
	}
}
