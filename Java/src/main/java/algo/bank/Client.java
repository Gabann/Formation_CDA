package algo.bank;

import java.util.ArrayList;
import java.util.List;

public class Client
{
	static int clientCount;
	String firstName;
	String lastName;
	int id;
	String phoneNumber;
	List<BankAccount> bankAccountList = new ArrayList<>();

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

	public void addBankAccount(BankAccount bankAccount)
	{
		bankAccountList.add(bankAccount);
	}
}
