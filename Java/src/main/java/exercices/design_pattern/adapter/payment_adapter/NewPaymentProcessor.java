package exercices.design_pattern.adapter.payment_adapter;

public class NewPaymentProcessor
{
	void authenticate(String apiKey)
	{
		System.out.println("Authenticate");
	}

	void pay(double amount)
	{
		System.out.println("New payment system");
	}
}
