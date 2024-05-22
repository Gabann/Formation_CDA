package jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Test
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	public Test()
	{
	}

	public Test(Builder builder)
	{
		id = builder.id;
		name = builder.name;
	}

	public static final class Builder
	{
		private int id;
		private String name;

		public Builder()
		{
		}

		public Builder id(int val)
		{
			id = val;
			return this;
		}

		public Builder name(String val)
		{
			name = val;
			return this;
		}

		public Test build()
		{
			return new Test(this);
		}
	}
}
