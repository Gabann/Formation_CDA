package exercices.document_logging;

public class Document implements DocumentActions
{
	String title;
	String content;

	public Document(String title, String content)
	{
		this.title = title;
		this.content = content;
	}

	@Override
	public void read(Document document)
	{
		System.out.println(document.content);
	}

	@Override
	public void write(Document document, String newContent)
	{
		document.content = newContent;
	}
}
