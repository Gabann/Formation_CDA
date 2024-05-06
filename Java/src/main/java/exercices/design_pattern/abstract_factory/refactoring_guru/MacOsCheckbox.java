package exercices.design_pattern.abstract_factory.refactoring_guru;


/**
 * All products families have the same varieties (MacOS/Windows).
 * <p>
 * This is a variant of a checkbox.
 */
public class MacOsCheckbox implements Checkbox
{

	@Override
	public void paint()
	{
		System.out.println("You have created MacOSCheckbox.");
	}
}
