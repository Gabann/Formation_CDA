package com.example.mvc.ex_01.entity;

public class Todo
{
	String name;
	String description;
	boolean isDone;

	public Todo(String name, String description, boolean isDone)
	{
		this.name = name;
		this.description = description;
		this.isDone = isDone;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public boolean isDone()
	{
		return isDone;
	}

	public void setDone(boolean done)
	{
		isDone = done;
	}
}
