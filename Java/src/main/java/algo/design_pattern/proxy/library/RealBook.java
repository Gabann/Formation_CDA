package algo.design_pattern.proxy.library;

public class RealBook implements BookReader
{
	String title;
	String content;

	public RealBook(String title, String content)
	{
		this.title = title;
		this.content = content;
	}

	@Override
	public void read()
	{
		System.out.println("Title: " + this.title);
		System.out.println("Content: " + this.content);
	}
}
