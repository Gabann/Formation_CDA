package jdbc.tp_zoo.entity;

public class Animal
{
	int id;
	String name;
	String race;
	String description;
	String habitat;
	int age;

	private Animal(Builder builder)
	{
		name = builder.name;
		race = builder.race;
		description = builder.description;
		habitat = builder.habitat;
		age = builder.age;
		id = builder.id;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public String getRace()
	{
		return race;
	}

	public String getDescription()
	{
		return description;
	}

	public String getHabitat()
	{
		return habitat;
	}

	public int getAge()
	{
		return age;
	}

	public static final class Builder
	{
		private String name;
		private String race;
		private String description;
		private String habitat;
		private int age;
		private int id;

		public Builder name(String val)
		{
			name = val;
			return this;
		}

		public Builder race(String val)
		{
			race = val;
			return this;
		}

		public Builder description(String val)
		{
			description = val;
			return this;
		}

		public Builder habitat(String val)
		{
			habitat = val;
			return this;
		}

		public Builder age(int val)
		{
			age = val;
			return this;
		}

		public Builder id(int val)
		{
			id = val;
			return this;
		}

		public Animal build()
		{
			return new Animal(this);
		}
	}
}
