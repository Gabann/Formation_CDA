package jdbc.tp_recipe.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Step
{
	int id;
	String description;
	int idRecipe;

	private Step(Builder builder)
	{
		setId(builder.id);
		setDescription(builder.description);
		setIdRecipe(builder.idRecipe);
	}

	public static final class Builder
	{
		private int id;
		private String description;
		private int idRecipe;

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

		public Builder idRecipe(int val)
		{
			idRecipe = val;
			return this;
		}

		public Step build()
		{
			return new Step(this);
		}
	}
}
