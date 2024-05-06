package exercices.design_pattern.abstract_factory.refactoring_guru;

/**
 * All products families have the same varieties (MacOS/Windows).
 * <p>
 * This is another variant of a button.
 */
public class WindowsButton implements Button
{

	@Override
	public void paint()
	{
		System.out.println("You have created WindowsButton.");
	}
}
