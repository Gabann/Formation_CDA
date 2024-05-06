package exercices.design_pattern.mediator.refactoring_guru.components;


import exercices.design_pattern.mediator.refactoring_guru.mediator.Mediator;
import exercices.design_pattern.mediator.refactoring_guru.mediator.Note;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * EN: Concrete components don't talk with each other. They have only one
 * communication channel–sending requests to the mediator.
 * <p>
 * RU: Конкретные компоненты никак не связаны между собой. У них есть только
 * один канал общения – через отправку уведомлений посреднику.
 */
public class AddButton extends JButton implements Component
{
	private Mediator mediator;

	public AddButton()
	{
		super("Add");
	}

	@Override
	public void setMediator(Mediator mediator)
	{
		this.mediator = mediator;
	}

	@Override
	protected void fireActionPerformed(ActionEvent actionEvent)
	{
		mediator.addNewNote(new Note());
	}

	@Override
	public String getName()
	{
		return "AddButton";
	}
}
