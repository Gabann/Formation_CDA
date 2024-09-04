package org.example.ex_01;

import org.example.ex_01.layout.Calculator;

import javax.swing.*;
import java.awt.*;

public class Main
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Calculator");
		frame.setSize(600, 900);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.add(new Calculator().getPanel());

		frame.setVisible(true);
	}
}
