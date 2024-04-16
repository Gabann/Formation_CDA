package exercices.stationery;

public class Lot extends Article
{
	int articleId;
	int quantity;
	double priceReductionPercentage;

	public Lot(String name, int articleId, int quantity, double priceReductionPercentage)
	{
		super(getArticleById(articleId).getPrice() * quantity, name);
		this.articleId = articleId;
		this.quantity = quantity;
		this.priceReductionPercentage = priceReductionPercentage;
	}
}
