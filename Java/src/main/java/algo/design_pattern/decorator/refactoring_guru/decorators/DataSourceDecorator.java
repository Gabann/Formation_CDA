package algo.design_pattern.decorator.refactoring_guru.decorators;

public class DataSourceDecorator implements DataSource
{
	private final DataSource wrappee;

	DataSourceDecorator(DataSource source)
	{
		this.wrappee = source;
	}

	@Override
	public void writeData(String data)
	{
		wrappee.writeData(data);
	}

	@Override
	public String readData()
	{
		return wrappee.readData();
	}
}
