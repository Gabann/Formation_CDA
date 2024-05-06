package exercices.document_logging;

public class Main
{
	public static void main(String[] args)
	{
		Document document = new Document("document", "content");
		DocumentLoggerProxy documentLoggerProxy = new DocumentLoggerProxy();

		documentLoggerProxy.read(document);
		System.out.println(documentLoggerProxy.logs);

		documentLoggerProxy.write(document, "modified content");
		System.out.println(documentLoggerProxy.logs);

		documentLoggerProxy.read(document);
		System.out.println(documentLoggerProxy.logs);
	}
}
