package algo.design_pattern.proxy.document_logging;

public interface DocumentActions
{
	void read(Document document);

	void write(Document document, String newContent);
}
