package exercices.design_pattern.abstract_factory.refactoring_guru;


/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class MacOsFactory implements GUIFactory
{

	@Override
	public Button createButton()
	{
		return new MacOsButton();
	}

	@Override
	public Checkbox createCheckbox()
	{
		return new MacOsCheckbox();
	}
}
