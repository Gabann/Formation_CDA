package algo.design_pattern.abstract_factory.refactoring_guru;

/**
 * All products families have the same varieties (MacOS/Windows).
 * <p>
 * This is a MacOS variant of a button.
 */
public class MacOsButton implements Button
{

	@Override
	public void paint()
	{
		System.out.println("You have created MacOSButton.");
	}
}
