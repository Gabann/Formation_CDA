package exercices.stationery;

public class InvoiceLine
{
	int quantity;

	int articleId;
	double price;

	public InvoiceLine(int quantity, int articleId)
	{
		this.quantity = quantity;
		this.articleId = articleId;
		this.price = quantity * ((Article) SoldItem.getArticleById(articleId)).getPrice();
	}

	public InvoiceLine(Lot lot)
	{
		this.quantity = lot.quantity;
		this.articleId = lot.articleId;
		this.price = lot.quantity * ((Article) SoldItem.getArticleById(lot.articleId)).getPrice() * (1 - (lot.priceReductionPercentage / 100));
	}

	@Override
	public String toString()
	{
		Article article = (Article) SoldItem.getArticleById(articleId);
		return String.format("Quantity: %d, Article id: %d, Article name: %s, Article price: %.2f, Total price: %.2f %n",
				quantity, article.getId(), article.getName(), article.getPrice(), price);
	}
}
