package exercices.bank;

public class Operation
{
	static int operationCount = 0;
	int id;
	double amount;
	OperationType operationType;

	public Operation(double amount, OperationType operationType)
	{
		this.id = operationCount;
		this.amount = amount;
		this.operationType = operationType;
		operationCount++;
	}

	public enum OperationType
	{
		DEPOSIT,
		WITHDRAWAL
	}
}
