package algo.design_pattern.proxy.library;

public class Main
{
	public static void main(String[] args)
	{
		RealBook book1 = new RealBook("book1", "book1");
		var proxy = new SecuredBookProxy(book1, true);

		proxy.read();

		proxy.setUserConnected(false);

		try
		{
			proxy.read();
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}
	}
}
