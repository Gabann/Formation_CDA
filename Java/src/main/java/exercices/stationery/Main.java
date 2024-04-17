package exercices.stationery;

public class Main
{
	public static void main(String[] args)
	{
		var pen1 = new Pen(1, "Blue pen", "Blue");
		var ream1 = new PaperReam(3, "5 grams paper ream", 5);
		var lot1 = new BulkProduct(pen1.getId(), 50, 25);

		var invoice1 = new CustomerInvoice("John doe");
		invoice1.addLine(new InvoiceItem(3, pen1.getId()));
		invoice1.addLine(new InvoiceItem(5, ream1.getId()));
		invoice1.addLine(new InvoiceItem(lot1));


		System.out.println(invoice1);
		System.out.println(invoice1.getTotalPrice());
	}
}
