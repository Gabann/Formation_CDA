package org.example.ex_02;

import org.example.ex_02.layout.Form;
import org.example.ex_02.layout.PersonTable;

import javax.swing.*;
import java.awt.*;

public class Main
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Complex two panel example");
		frame.setSize(600, 900);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.BLACK);

		frame.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;

		Form form = new Form();
		PersonTable personTable = new PersonTable();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		frame.add(form.getPanel(), gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		frame.add(personTable.getPanel(), gbc);

		frame.setVisible(true);
	}
}
