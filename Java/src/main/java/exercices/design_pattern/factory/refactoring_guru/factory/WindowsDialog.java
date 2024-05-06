package exercices.design_pattern.factory.refactoring_guru.factory;


import exercices.design_pattern.factory.refactoring_guru.buttons.Button;
import exercices.design_pattern.factory.refactoring_guru.buttons.WindowsButton;

/**
 * EN: Windows Dialog will produce Windows buttons.
 * <p>
 * RU: Диалог на элементах операционной системы.
 */
public class WindowsDialog extends Dialog
{

	@Override
	public Button createButton()
	{
		return new WindowsButton();
	}
}
