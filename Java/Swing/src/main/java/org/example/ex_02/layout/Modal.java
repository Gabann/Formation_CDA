package org.example.ex_02.layout;

import lombok.Getter;
import org.example.ex_02.entity.Person;

import javax.swing.*;
import java.awt.*;


@Getter
public class Modal
{
	private final JDialog dialog;
	private final JPanel panel;

	public Modal(JFrame parentFrame, Person person)
	{
		dialog = new JDialog(parentFrame, "Person Details", true);
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;

		JLabel nameLabel = new JLabel("Name: " + person.getName());
		JLabel emailLabel = new JLabel("Email: " + person.getEmail());
		JLabel genderLabel = new JLabel("Gender: " + person.getGender().name());

		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(nameLabel, gbc);

		gbc.gridy = 1;
		panel.add(emailLabel, gbc);

		gbc.gridy = 2;
		panel.add(genderLabel, gbc);

		dialog.add(panel);
		dialog.setSize(300, 200);
		dialog.setLocationRelativeTo(parentFrame);
	}

	public void showDialog()
	{
		dialog.setVisible(true);
	}
}
