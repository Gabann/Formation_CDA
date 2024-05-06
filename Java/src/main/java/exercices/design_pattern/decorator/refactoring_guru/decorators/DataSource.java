package exercices.design_pattern.decorator.refactoring_guru.decorators;

public interface DataSource
{
	void writeData(String data);

	String readData();
}
