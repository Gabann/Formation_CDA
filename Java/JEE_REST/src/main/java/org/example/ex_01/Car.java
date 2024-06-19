package org.example.ex_01;

public class Car
{
	private static Long carCount = 0L;
	String brand;
	int constructionYear;
	String color;
	private Long id;

	public Car()
	{
	}

	public Car(String brand, int constructionYear, String color)
	{
		this.id = ++carCount;
		this.brand = brand;
		this.constructionYear = constructionYear;
		this.color = color;
	}

	public String getBrand()
	{
		return brand;
	}

	public int getConstructionYear()
	{
		return constructionYear;
	}

	public String getColor()
	{
		return color;
	}

	public Long getId()
	{
		return id;
	}
}
