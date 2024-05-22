package jdbc.tp_recipe.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingredient
{
	int id;
	String name;

	private Ingredient(Builder builder)
	{
		setId(builder.id);
		setName(builder.name);
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

		public Ingredient build()
		{
			return new Ingredient(this);
		}
	}
}
