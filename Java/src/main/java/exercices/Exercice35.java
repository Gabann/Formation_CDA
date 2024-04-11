package exercices;

public class Exercice35
{
	public static void IHM()
	{
		var client1 = new Client("Eda", "Clawthorne", "+33606060606");
		var account1 = new CheckingBankAccount(client1);
		account1.deposit(99999);

		System.out.println(account1.balance);
		account1.withDraw(999999999999999999999.0);
	}
}
