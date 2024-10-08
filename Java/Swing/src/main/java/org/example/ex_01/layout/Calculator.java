package org.example.ex_01.layout;

import lombok.Getter;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.swing.*;
import java.awt.*;

@Getter
public class Calculator
{
	private final JLabel label;
	private final JPanel panel;
	String expression = "";

	public Calculator()
	{
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.weightx = 1;
		gbc.weighty = 1;

		label = new JLabel("42");
		label.setOpaque(true);
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.PLAIN, 90));

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH;
		panel.add(label, gbc);

		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;

		JButton buttonC = new JButton("C");
		buttonC.setBackground(Color.LIGHT_GRAY);
		buttonC.setForeground(Color.BLACK);

		JButton buttonPositiveNegative = new JButton("+/-");
		buttonPositiveNegative.setBackground(Color.LIGHT_GRAY);
		buttonPositiveNegative.setForeground(Color.BLACK);

		JButton buttonPercentage = new JButton("%");
		buttonPercentage.setBackground(Color.LIGHT_GRAY);
		buttonPercentage.setForeground(Color.BLACK);

		JButton button7 = new JButton("7");
		button7.setBackground(Color.BLACK);
		button7.setForeground(Color.white);

		JButton button8 = new JButton("8");
		button8.setBackground(Color.BLACK);
		button8.setForeground(Color.white);

		JButton button9 = new JButton("9");
		button9.setBackground(Color.BLACK);
		button9.setForeground(Color.white);

		JButton button4 = new JButton("4");
		button4.setBackground(Color.BLACK);
		button4.setForeground(Color.white);

		JButton button5 = new JButton("5");
		button5.setBackground(Color.BLACK);
		button5.setForeground(Color.white);

		JButton button6 = new JButton("6");
		button6.setBackground(Color.BLACK);
		button6.setForeground(Color.white);

		JButton button1 = new JButton("1");
		button1.setBackground(Color.BLACK);
		button1.setForeground(Color.white);

		JButton button2 = new JButton("2");
		button2.setBackground(Color.BLACK);
		button2.setForeground(Color.white);

		JButton button3 = new JButton("3");
		button3.setBackground(Color.BLACK);
		button3.setForeground(Color.white);

		JButton button0 = new JButton("0");
		button0.setBackground(Color.BLACK);
		button0.setForeground(Color.white);

		JButton buttonComma = new JButton(",");
		buttonComma.setBackground(Color.BLACK);
		buttonComma.setForeground(Color.white);

		JButton buttonDivide = new JButton("/");
		buttonDivide.setBackground(Color.ORANGE);
		buttonDivide.setForeground(Color.white);

		JButton buttonMultiply = new JButton("*");
		buttonMultiply.setBackground(Color.ORANGE);
		buttonMultiply.setForeground(Color.white);

		JButton buttonMinus = new JButton("-");
		buttonMinus.setBackground(Color.ORANGE);
		buttonMinus.setForeground(Color.white);

		JButton buttonPlus = new JButton("+");
		buttonPlus.setBackground(Color.ORANGE);
		buttonPlus.setForeground(Color.white);

		JButton buttonEqual = new JButton("=");
		buttonEqual.setBackground(Color.ORANGE);
		buttonEqual.setForeground(Color.white);

		button0.addActionListener(e ->
		{
			expression += "0";
			updateUi();
		});

		button1.addActionListener(e ->
		{
			expression += "1";
			updateUi();
		});

		button2.addActionListener(e ->
		{
			expression += "2";
			updateUi();
		});

		button3.addActionListener(e ->
		{
			expression += "3";
			updateUi();
		});

		button4.addActionListener(e ->
		{
			expression += "4";
			updateUi();
		});

		button5.addActionListener(e ->
		{
			expression += "5";
			updateUi();
		});

		button6.addActionListener(e ->
		{
			expression += "6";
			updateUi();
		});

		button7.addActionListener(e ->
		{
			expression += "7";
			updateUi();
		});

		button8.addActionListener(e ->
		{
			expression += "8";
			updateUi();
		});

		button9.addActionListener(e ->
		{
			expression += "9";
			updateUi();
		});

		buttonComma.addActionListener(e ->
		{
			expression += ",";
			updateUi();
		});

		buttonPlus.addActionListener(e ->
		{
			expression += "+";
			updateUi();
		});

		buttonMinus.addActionListener(e ->
		{
			expression += "-";
			updateUi();
		});

		buttonMultiply.addActionListener(e ->
		{
			expression += "*";
			updateUi();
		});

		buttonDivide.addActionListener(e ->
		{
			expression += "/";
			updateUi();
		});

		buttonEqual.addActionListener(e ->
		{
			evaluateExpression();
			updateUi();
		});

		buttonC.addActionListener(e ->
		{
			expression = "";
			updateUi();
		});

		buttonPositiveNegative.addActionListener(e ->
		{
			if (expression.startsWith("-"))
			{
				expression = expression.substring(1);
			}
			else
			{
				expression = "-" + expression;
			}

			updateUi();
		});

		buttonPercentage.addActionListener(e ->
		{
			expression += "/100";
			updateUi();
		});


		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(buttonC, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(buttonPositiveNegative, gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		panel.add(buttonPercentage, gbc);

		gbc.gridx = 3;
		gbc.gridy = 2;
		panel.add(buttonDivide, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(button7, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		panel.add(button8, gbc);

		gbc.gridx = 2;
		gbc.gridy = 3;
		panel.add(button9, gbc);

		gbc.gridx = 3;
		gbc.gridy = 3;
		panel.add(buttonMultiply, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(button4, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		panel.add(button5, gbc);

		gbc.gridx = 2;
		gbc.gridy = 4;
		panel.add(button6, gbc);

		gbc.gridx = 3;
		gbc.gridy = 4;
		panel.add(buttonMinus, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(button1, gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		panel.add(button2, gbc);

		gbc.gridx = 2;
		gbc.gridy = 5;
		panel.add(button3, gbc);

		gbc.gridx = 2;
		gbc.gridy = 5;
		panel.add(buttonComma, gbc);

		gbc.gridx = 3;
		gbc.gridy = 5;
		panel.add(buttonPlus, gbc);

		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(button0, gbc);

		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 6;
		panel.add(buttonComma, gbc);

		gbc.gridx = 3;
		gbc.gridy = 6;
		panel.add(buttonEqual, gbc);
	}

	public void updateUi()
	{
		panel.revalidate();
		panel.repaint();
		label.setText(expression);
	}

	public void evaluateExpression()
	{
		expression = new ExpressionBuilder(expression).build().evaluate() + "";
	}
}
