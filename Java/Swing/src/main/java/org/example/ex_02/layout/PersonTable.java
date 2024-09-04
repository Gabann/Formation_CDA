package org.example.ex_02.layout;

import lombok.Getter;
import org.example.ex_02.PersonListChangeManager;
import org.example.ex_02.PersonListListener;
import org.example.ex_02.entity.Person;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

@Getter
public class PersonTable implements PersonListListener
{
	private final JPanel panel;
	private final JTable table;
	private final DefaultTableModel tableModel;

	public PersonTable()
	{
		PersonListChangeManager.addListener(this);

		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Table of persons", TitledBorder.CENTER,
				TitledBorder.TOP));

		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;

		String[] columnNames = {"Name", "Email", "Gender"};

		tableModel = new DefaultTableModel(columnNames, 0);

		table = new JTable(tableModel);

		JButton detailsButton = new JButton("Details");

		detailsButton.addActionListener(e ->
		{
			Person person = getSelectedPerson();
			if (person != null)
			{
				showPersonDetails(person);
			}
		});

		JButton removeButton = new JButton("Remove");

		removeButton.addActionListener(e ->
		{
			Person person = getSelectedPerson();
			if (person != null)
			{
				Person.removePerson(person);
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);

		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		panel.add(scrollPane, gbc);

		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		panel.add(detailsButton, gbc);

		gbc.gridx = 1;
		panel.add(removeButton, gbc);
	}

	public Person getSelectedPerson()
	{
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1)
		{
			String name = (String) tableModel.getValueAt(selectedRow, 0);
			String email = (String) tableModel.getValueAt(selectedRow, 1);
			Person.Gender gender = Person.Gender.valueOf((String) tableModel.getValueAt(selectedRow, 2));
			return new Person(name, email, gender);
		}
		return null;
	}

	public void showPersonDetails(Person person)
	{
		JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
		Modal modal = new Modal(parentFrame, person);
		modal.showDialog();
	}

	@Override
	public void OnPersonListChanged(List<Person> personList)
	{
		tableModel.setRowCount(0);
		for (Person person : personList)
		{
			addPerson(person.getName(), person.getEmail(), person.getGender().toString());
		}
	}

	public void addPerson(String name, String email, String gender)
	{
		tableModel.addRow(new Object[]{name, email, gender});
	}
}
