package exercices.design_pattern.mediator.refactoring_guru.mediator;


import exercices.design_pattern.mediator.refactoring_guru.components.Component;

import javax.swing.*;

/**
 * EN: Common mediator interface.
 * <p>
 * RU: Общий интерфейс посредников.
 */
public interface Mediator
{
	void addNewNote(Note note);

	void deleteNote();

	void getInfoFromList(Note note);

	void saveChanges();

	void markNote();

	void clear();

	void sendToFilter(ListModel listModel);

	void setElementsList(ListModel list);

	void registerComponent(Component component);

	void hideElements(boolean flag);

	void createGUI();
}
