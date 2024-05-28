package algo.stationery;

import java.util.HashMap;

public abstract class SoldItem
{
	private static final HashMap<Integer, SoldItem> articleHashMap = new HashMap<>();
	static int articleCount = 0;
	private final int id;

	protected SoldItem()
	{
		this.id = ++articleCount;
		articleHashMap.put(id, this);
	}

	public static SoldItem getItemById(int id)
	{
		return articleHashMap.get(id);
	}

	public int getId()
	{
		return id;
	}
}
