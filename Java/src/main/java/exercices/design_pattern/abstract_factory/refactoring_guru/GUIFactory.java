package exercices.design_pattern.abstract_factory.refactoring_guru;

/**
 * Abstract factory knows about all (abstract) product types.
 */
public interface GUIFactory
{
	Button createButton();

	Checkbox createCheckbox();
}
