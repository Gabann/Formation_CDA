package exercices;

import java.util.List;

public class Client
{
	static int clientCount;
	String firstName;
	String lastName;
	int id;
	String phoneNumber;
	List<BankAccount> bankAccountList;

	public Client(String firstName, String lastName, String phoneNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = clientCount;
		this.phoneNumber = phoneNumber;
		clientCount++;
	}

	public List<BankAccount> getBankAccountList()
	{
		return bankAccountList;
	}

	public void setBankAccountList(List<BankAccount> bankAccountList)
	{
		this.bankAccountList = bankAccountList;
	}
}
