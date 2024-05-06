package exercices.design_pattern.proxy.library;

public class SecuredBookProxy implements BookReader
{
	boolean isUserConnected;
	RealBook book;

	public SecuredBookProxy(RealBook book, boolean isUserConnected)
	{
		this.isUserConnected = isUserConnected;
		this.book = book;
	}

	public void setUserConnected(boolean userConnected)
	{
		isUserConnected = userConnected;
	}

	@Override
	public void read()
	{
		if (isUserConnected)
		{
			book.read();
		}
		else
		{
			throw new RuntimeException("Not connected");
		}
	}
}
