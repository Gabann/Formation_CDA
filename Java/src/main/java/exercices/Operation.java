package exercices;

enum OperationType
{
	DEPOSIT,
	WITHDRAWAL
}

public class Operation
{
	static int operationCount;
	int id;
	double amount;
	OperationType operationType;

	private Operation(double amount, OperationType operationType)
	{
		this.id = operationCount;
		this.amount = amount;
		this.operationType = operationType;
		operationCount++;
	}
}
