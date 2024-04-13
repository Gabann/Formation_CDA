package exercices.procedural;

public class WhatHour
{
	static void whatHour()
	{
		whatHour("12h00");
	}

	static void whatHour(String hour)
	{
		System.out.printf("It is %s o'clock%n", hour);
	}

	public static void main(String[] args)
	{
		whatHour();
		whatHour("14h00");
	}
}
