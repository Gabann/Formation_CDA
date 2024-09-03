package org.example.ex_01.layout;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;

public class Calculator {
	    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(600, 900);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
	    frame.getContentPane().setBackground(Color.BLACK);

	    ScriptEngineManager manager = new ScriptEngineManager();
	    ScriptEngine engine = manager.getEngineByName("js");
	    try
	    {
		    Object result = engine.eval("4*5");
	    }
	    catch (ScriptException e)
	    {
		    throw new RuntimeException(e);
	    }



	    JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
	    frame.getContentPane().setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();

	    gbc.weightx = 1;
	    gbc.weighty = 1;

	    JLabel label = new JLabel("42");
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

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
