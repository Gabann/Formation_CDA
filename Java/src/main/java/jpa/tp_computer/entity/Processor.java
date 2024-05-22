package jpa.tp_computer.entity;

import javax.persistence.*;

@Entity
public class Processor
{
	String brand;
	String model;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;


	public Processor()
	{
	}

	public Processor(Builder builder)
	{
		brand = builder.brand;
		model = builder.model;
	}


	public static final class Builder
	{
		private String brand;
		private String model;

		public Builder()
		{
		}

		public Builder brand(String val)
		{
			brand = val;
			return this;
		}

		public Builder model(String val)
		{
			model = val;
			return this;
		}

		public Processor build()
		{
			return new Processor(this);
		}
	}
}
