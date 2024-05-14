package jdbc.tp_zoo.entity;

import java.time.LocalDate;

public class Meal
{
	int id;
	String description;
	LocalDate date;
	int animalId;

	private Meal(Builder builder)
	{
		setId(builder.id);
		description = builder.description;
		date = builder.date;
		animalId = builder.animalId;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getDescription()
	{
		return description;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public int getAnimalId()
	{
		return animalId;
	}


	public static final class Builder
	{
		private int id;
		private String description;
		private LocalDate date;
		private int animalId;

		public Builder()
		{
		}

		public Builder id(int val)
		{
			id = val;
			return this;
		}

		public Builder description(String val)
		{
			description = val;
			return this;
		}

		public Builder date(LocalDate val)
		{
			date = val;
			return this;
		}

		public Builder animalId(int val)
		{
			animalId = val;
			return this;
		}

		public Meal build()
		{
			return new Meal(this);
		}
	}
}
