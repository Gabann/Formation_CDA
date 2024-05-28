package algo.design_pattern.mediator.refactoring_guru;


import algo.design_pattern.mediator.refactoring_guru.components.*;
import algo.design_pattern.mediator.refactoring_guru.mediator.Editor;
import algo.design_pattern.mediator.refactoring_guru.mediator.Mediator;

import javax.swing.*;

/**
 * EN: Demo class. Everything comes together here.
 * <p>
 * RU: Демо-класс. Здесь всё сводится воедино.
 */
public class Demo
{
	public static void main(String[] args)
	{
		Mediator mediator = new Editor();

		mediator.registerComponent(new Title());
		mediator.registerComponent(new TextBox());
		mediator.registerComponent(new AddButton());
		mediator.registerComponent(new DeleteButton());
		mediator.registerComponent(new SaveButton());
		mediator.registerComponent(new List(new DefaultListModel()));
		mediator.registerComponent(new Filter());

		mediator.createGUI();
	}
}
