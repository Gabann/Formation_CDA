package exercices.library;

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
	public void read(RealBook book)
	{
		System.out.println("Title: " + book.title);
		System.out.println("Content: " + book.content);
	}
}
