package algo.stationery;

public class BulkProduct extends SoldItem
{
	int articleId;
	int quantity;
	double priceReductionPercentage;

	public BulkProduct(int articleId, int quantity, double priceReductionPercentage)
	{
		this.articleId = articleId;
		this.quantity = quantity;
		this.priceReductionPercentage = priceReductionPercentage;
	}
}
