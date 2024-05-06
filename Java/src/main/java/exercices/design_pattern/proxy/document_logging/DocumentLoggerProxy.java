package exercices.design_pattern.proxy.document_logging;

import java.util.ArrayList;
import java.util.List;

public class DocumentLoggerProxy implements DocumentActions
{
	List<String> logs = new ArrayList<>();

	@Override
	public void read(Document document)
	{
		String log = "Action: read" + "\n" +
				"Time: " + System.currentTimeMillis() + "\n" +
				"Document: " + document;
		logs.add(log);

		document.read(document);
	}

	@Override
	public void write(Document document, String newContent)
	{
		String log = "Action: write" + "\n" +
				"Time: " + System.currentTimeMillis() + "\n" +
				"Document: " + document + "\n" +
				"New content: " + newContent;
		logs.add(log);
		document.write(document, newContent);
	}
}
