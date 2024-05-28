package algo.design_pattern.factory.refactoring_guru.buttons;

/**
 * EN: HTML button implementation.
 * <p>
 * RU: Реализация HTML кнопок.
 */
public class HtmlButton implements Button
{

	public void render()
	{
		System.out.println("<button>Test Button</button>");
		onClick();
	}

	public void onClick()
	{
		System.out.println("Click! Button says - 'Hello World!'");
	}
}
