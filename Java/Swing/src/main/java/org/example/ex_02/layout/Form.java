package org.example.ex_02.layout;

import lombok.Getter;
import org.example.ex_02.entity.Person;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Collections;

@Getter
public class Form
{
	private final JPanel panel;
	private final ButtonGroup genderGroup;

	public Form()
	{
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Form", TitledBorder.CENTER,
				TitledBorder.TOP));

		gbc.weightx = 1;
		gbc.weighty = 1;

		JLabel nameLabel = new JLabel("Name:");
		JLabel emailLabel = new JLabel("Email:");
		JLabel genderLabel = new JLabel("Gender:");

		JTextArea nameTextArea = new JTextArea(1, 20);
		JScrollPane nameScrollPane = new JScrollPane(nameTextArea);

		JTextArea emailTextArea = new JTextArea(1, 20);
		JScrollPane emailScrollPane = new JScrollPane(emailTextArea);

		genderGroup = new ButtonGroup();

		JButton addButton = new JButton("Add");
		addButton.addActionListener(e ->
		{
			Person.Gender selectedGender = getSelectedGender();
			if (selectedGender != null)
			{
				Person person = new Person(nameTextArea.getText(), emailTextArea.getText(), selectedGender);
				Person.addPerson(person);
			}
		});

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		panel.add(nameLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		panel.add(nameScrollPane, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		panel.add(emailLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		panel.add(emailScrollPane, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		panel.add(genderLabel, gbc);

		for (Person.Gender gender : Person.Gender.values())
		{
			JRadioButton button = new JRadioButton(gender.name());
			genderGroup.add(button);
			gbc.gridx++;
			panel.add(button, gbc);
		}

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		panel.add(addButton, gbc);
	}

	private Person.Gender getSelectedGender()
	{
		for (AbstractButton button : Collections.list(genderGroup.getElements()))
		{
			if (button.isSelected())
			{
				return Person.Gender.valueOf(button.getText().toUpperCase());
			}
		}
		return null;
	}
}
