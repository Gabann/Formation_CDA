package exercices.stationery;

import java.time.LocalDate;
import java.util.Arrays;

public class Invoice
{
	static int invoiceCount = 0;
	int id;
	String client;
	LocalDate localDate;
	InvoiceLine[] invoiceLinesArray;

	public Invoice(String client)
	{
		this(client, 10);
	}

	public Invoice(String client, int numberOfLines)
	{
		this.id = ++invoiceCount;
		this.client = client;
		this.localDate = LocalDate.now();
		this.invoiceLinesArray = new InvoiceLine[numberOfLines];
	}

	void addLine(InvoiceLine invoiceLine)
	{
		for (int i = 0; i < invoiceLinesArray.length; i++)
		{
			if (invoiceLinesArray[i] == null)
			{
				invoiceLinesArray[i] = invoiceLine;
				break;
			}
		}
	}

	double getTotalPrice()
	{
		double sum = 0;

		for (int i = 0; i < invoiceLinesArray.length; i++)
		{
			if (invoiceLinesArray[i] == null)
			{
				continue;
			}

			sum += invoiceLinesArray[i].price;
		}

		return sum;
	}

	@Override
	public String toString()
	{
		return "Invoice{" +
				"id=" + id +
				", client='" + client + '\'' +
				", localDate=" + localDate + "\n" +
				", invoiceLinesArray=" + Arrays.toString(invoiceLinesArray) +
				'}';
	}
}

