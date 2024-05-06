package exercices.document_logging;

public interface DocumentActions
{
	void read(Document document);

	void write(Document document, String newContent);
}
