package exercices.design_pattern.state.refactoring_guru;


import exercices.design_pattern.state.refactoring_guru.ui.Player;
import exercices.design_pattern.state.refactoring_guru.ui.UI;

/**
 * EN: Demo class. Everything comes together here.
 * <p>
 * RU: Демо-класс. Здесь всё сводится воедино.
 */
public class Demo
{
	public static void main(String[] args)
	{
		Player player = new Player();
		UI ui = new UI(player);
		ui.init();
	}
}
