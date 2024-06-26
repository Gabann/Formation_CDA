package algo.design_pattern.abstract_factory.tp.entity.impl;

import algo.design_pattern.abstract_factory.tp.entity.AbstractProductBuilder;
import algo.design_pattern.abstract_factory.tp.entity.Product;

public class Computer extends Product
{
	int ramGb;
	String processor;

	private Computer(ComputerBuilder computerBuilder)
	{
		super(computerBuilder);
		this.ramGb = computerBuilder.ramGb;
		this.processor = computerBuilder.processor;
	}

	@Override
	public String toString()
	{
		return "Computer{" +
				"ramGb=" + ramGb +
				", processor='" + processor + '\'' +
				"} " + super.toString();
	}

	public static class ComputerBuilder extends AbstractProductBuilder<Computer>
	{
		int ramGb;
		String processor;

		public ComputerBuilder ramGb(int ramGb)
		{
			this.ramGb = ramGb;
			return this;
		}

		public ComputerBuilder processor(String processor)
		{
			this.processor = processor;
			return this;
		}

		@Override
		public Computer build()
		{
			return new Computer(this);
		}
	}
}
