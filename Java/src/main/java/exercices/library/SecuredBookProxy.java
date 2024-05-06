package exercices.library;

public class SecuredBookProxy implements BookReader
{
	boolean isUserConnected;

	public SecuredBookProxy(boolean isUserConnected)
	{
		this.isUserConnected = isUserConnected;
	}

	@Override
	public void read(RealBook book)
	{
		if (isUserConnected)
		{
			book.read(book);
		}
		else
		{
			throw new RuntimeException("Not connected");
		}
	}
}
