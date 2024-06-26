package algo.design_pattern.mediator.refactoring_guru.components;


import algo.design_pattern.mediator.refactoring_guru.mediator.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * EN: Concrete components don't talk with each other. They have only one
 * communication channel–sending requests to the mediator.
 * <p>
 * RU: Конкретные компоненты никак не связаны между собой. У них есть только
 * один канал общения – через отправку уведомлений посреднику.
 */
public class DeleteButton extends JButton implements Component
{
	private Mediator mediator;

	public DeleteButton()
	{
		super("Del");
	}

	@Override
	public void setMediator(Mediator mediator)
	{
		this.mediator = mediator;
	}

	@Override
	protected void fireActionPerformed(ActionEvent actionEvent)
	{
		mediator.deleteNote();
	}

	@Override
	public String getName()
	{
		return "DelButton";
	}
}
