package jpa.tp_computer.entity;

import javax.persistence.*;

@Entity
public class Computer
{
	@ManyToOne
	Processor cpu;
	String gpu;
	int ram;
	@Embedded
	Address ipAddress;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	public Computer()
	{
	}

	private Computer(Builder builder)
	{
		cpu = builder.cpu;
		gpu = builder.gpu;
		ram = builder.ram;
		ipAddress = builder.ipAddress;
	}


	public static final class Builder
	{
		private Processor cpu;
		private String gpu;
		private int ram;
		private Address ipAddress;

		public Builder()
		{
		}

		public Builder cpu(Processor val)
		{
			cpu = val;
			return this;
		}

		public Builder gpu(String val)
		{
			gpu = val;
			return this;
		}

		public Builder ram(int val)
		{
			ram = val;
			return this;

		}

		public Builder ipAddress(Address val)
		{
			ipAddress = val;
			return this;
		}

		public Computer build()
		{
			return new Computer(this);
		}
	}
}
