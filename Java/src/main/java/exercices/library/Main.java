package exercices.library;

public class Main
{
	public static void main(String[] args)
	{
		RealBook book1 = new RealBook("book1", "book1");
		var proxy = new SecuredBookProxy(false);

		proxy = new SecuredBookProxy(true);
		proxy.read(book1);

		try
		{
			proxy = new SecuredBookProxy(false);
			proxy.read(book1);
		} catch (Exception e)
		{
			System.out.println("Something went wrong: " + e);
		}
	}
}
