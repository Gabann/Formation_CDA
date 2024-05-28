package algo.design_pattern.strategy.refactoring_guru;

public interface PayStrategy
{
	boolean pay(int paymentAmount);

	void collectPaymentDetails();
}
