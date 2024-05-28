package algo.design_pattern.adapter.payment_adapter;

public class OldToNewPaymentAdapter extends OldPaymentProcessor
{
	private final NewPaymentProcessor newPaymentProcessor;

	public OldToNewPaymentAdapter()
	{
		newPaymentProcessor = new NewPaymentProcessor();
	}

	@Override
	void pay(String accountNumber, double amount)
	{
		newPaymentProcessor.authenticate(accountNumber);
		newPaymentProcessor.pay(amount);
	}
}
