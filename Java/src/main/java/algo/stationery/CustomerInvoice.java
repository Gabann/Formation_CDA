package algo.stationery;

import java.time.LocalDate;
import java.util.Arrays;

public class CustomerInvoice
{
	static int invoiceCount = 0;
	int id;
	String client;
	LocalDate localDate;
	InvoiceItem[] invoiceLinesArray;

	public CustomerInvoice(String client)
	{
		this(client, 10);
	}

	public CustomerInvoice(String client, int numberOfLines)
	{
		this.id = ++invoiceCount;
		this.client = client;
		this.localDate = LocalDate.now();
		this.invoiceLinesArray = new InvoiceItem[numberOfLines];
	}

	void addLine(InvoiceItem invoiceLine)
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

