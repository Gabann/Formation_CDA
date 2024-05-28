package algo.design_pattern.mediator.refactoring_guru.components;


import algo.design_pattern.mediator.refactoring_guru.mediator.Mediator;

/**
 * EN: Common component interface.
 * <p>
 * RU: Общий интерфейс компонентов.
 */
public interface Component
{
	void setMediator(Mediator mediator);

	String getName();
}
