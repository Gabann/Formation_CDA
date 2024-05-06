package exercices.design_pattern.adapter.payment_adapter;

public class Main
{
	public static void main(String[] args)
	{
		OldPaymentProcessor paymentSystem = new OldToNewPaymentAdapter();
		paymentSystem.pay("123", 10);
	}
}
