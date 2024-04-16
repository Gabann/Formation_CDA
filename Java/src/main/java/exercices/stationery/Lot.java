package exercices.stationery;

public class Lot extends SoldItem
{
	int articleId;
	int quantity;
	double priceReductionPercentage;

	public Lot(int articleId, int quantity, double priceReductionPercentage)
	{
		this.articleId = articleId;
		this.quantity = quantity;
		this.priceReductionPercentage = priceReductionPercentage;
	}
}
