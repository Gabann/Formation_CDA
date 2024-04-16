package exercices.stationery;

import java.util.HashMap;

public class Article
{
	private static final HashMap<Integer, Article> articleHashMap = new HashMap<>();
	static int articleCount = 0;
	private final int id;
	private final double price;
	private final String name;

	public Article(double price, String name)
	{
		this.id = ++articleCount;
		this.price = price;
		this.name = name;
		articleHashMap.put(id, this);
	}

	public static Article getArticleById(int id)
	{
		return articleHashMap.get(id);
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public double getPrice()
	{
		return price;
	}

	@Override
	public String toString()
	{
		return String.format("Article{id=%d, price=%.2f, name='%s'}", id, price, name);
	}
}
