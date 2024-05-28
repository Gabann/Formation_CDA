package algo.design_pattern.factory.refactoring_guru.factory;


import algo.design_pattern.factory.refactoring_guru.buttons.Button;
import algo.design_pattern.factory.refactoring_guru.buttons.HtmlButton;

/**
 * EN: HTML Dialog will produce HTML buttons.
 * <p>
 * RU: HTML-диалог.
 */
public class HtmlDialog extends Dialog
{

	@Override
	public Button createButton()
	{
		return new HtmlButton();
	}
}
