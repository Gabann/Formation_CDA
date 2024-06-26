package algo.design_pattern.factory.refactoring_guru;


import algo.design_pattern.factory.refactoring_guru.factory.Dialog;
import algo.design_pattern.factory.refactoring_guru.factory.HtmlDialog;
import algo.design_pattern.factory.refactoring_guru.factory.WindowsDialog;

/**
 * EN: Demo class. Everything comes together here.
 * <p>
 * RU: Демо-класс. Здесь всё сводится воедино.
 */
public class Demo
{
	private static Dialog dialog;

	public static void main(String[] args)
	{
		configure();
		runBusinessLogic();
	}

	/**
	 * EN: The concrete factory is usually chosen depending on configuration or
	 * environment options.
	 * <p>
	 * RU: Приложение создаёт определённую фабрику в зависимости от конфигурации
	 * или окружения.
	 */
	static void configure()
	{
		if (System.getProperty("os.name").equals("Windows 10"))
		{
			dialog = new WindowsDialog();
		}
		else
		{
			dialog = new HtmlDialog();
		}
	}

	/**
	 * EN: All of the client code should work with factories and products
	 * through abstract interfaces. This way it does not care which factory it
	 * works with and what kind of product it returns.
	 * <p>
	 * RU: Весь остальной клиентский код работает с фабрикой и продуктами только
	 * через общий интерфейс, поэтому для него неважно какая фабрика была
	 * создана.
	 */
	static void runBusinessLogic()
	{
		dialog.renderWindow();
	}
}
