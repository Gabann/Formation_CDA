package exercices.bank;

public class Main
{
	public static void main(String[] args)
	{
		var client1 = new Client("Eda", "Clawthorne", "+33606060606");
		var account1 = new CheckingBankAccount(client1);

		account1.deposit(99999);
		account1.deposit(99999);
		account1.deposit(99999);
		account1.deposit(-99999);

		System.out.println(account1.balance);
		account1.withDraw(9999999999.0);

		System.out.println(account1.operationList);
	}
}
