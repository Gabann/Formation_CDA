package algo.design_pattern.adapter.payment_adapter;

public class OldPaymentProcessor
{
	void pay(String accountNumber, double amount)
	{
		System.out.println("Old payment system");
	}
}
