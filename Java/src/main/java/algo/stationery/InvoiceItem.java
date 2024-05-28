package algo.stationery;

public class InvoiceItem
{
	int quantity;

	int articleId;
	double price;

	public InvoiceItem(int quantity, int articleId)
	{
		this.quantity = quantity;
		this.articleId = articleId;
		this.price = quantity * ((Article) SoldItem.getItemById(articleId)).getPrice();
	}

	public InvoiceItem(BulkProduct lot)
	{
		this.quantity = lot.quantity;
		this.articleId = lot.articleId;
		this.price = lot.quantity * ((Article) SoldItem.getItemById(lot.articleId)).getPrice() * (1 - (lot.priceReductionPercentage / 100));
	}

	@Override
	public String toString()
	{
		Article article = (Article) SoldItem.getItemById(articleId);
		return String.format("Quantity: %d, Article id: %d, Article name: %s, Article price: %.2f, Total price: %.2f %n",
				quantity, article.getId(), article.getName(), article.getPrice(), price);
	}
}
