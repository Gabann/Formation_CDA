package jdbc.tp_zoo.entity;

public class CaretakerAnimal
{
	int id;
	int idAnimal;
	int idCaretaker;

	private CaretakerAnimal(Builder builder)
	{
		setId(builder.id);
		idAnimal = builder.idAnimal;
		idCaretaker = builder.idCaretaker;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getIdAnimal()
	{
		return idAnimal;
	}

	public int getIdCaretaker()
	{
		return idCaretaker;
	}

	public static final class Builder
	{
		private int id;
		private int idAnimal;
		private int idCaretaker;

		public Builder()
		{
		}

		public Builder id(int val)
		{
			id = val;
			return this;
		}

		public Builder idAnimal(int val)
		{
			idAnimal = val;
			return this;
		}

		public Builder idCaretaker(int val)
		{
			idCaretaker = val;
			return this;
		}

		public CaretakerAnimal build()
		{
			return new CaretakerAnimal(this);
		}
	}
}
