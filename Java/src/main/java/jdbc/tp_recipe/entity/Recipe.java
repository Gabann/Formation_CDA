package jdbc.tp_recipe.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recipe
{
	int id;
	String name;
	int prepTime;
	int prepCuisson;
	int difficulty;
	int idCategory;

	private Recipe(Builder builder)
	{
		setId(builder.id);
		setName(builder.name);
		setPrepTime(builder.prepTime);
		setPrepCuisson(builder.prepCuisson);
		setDifficulty(builder.difficulty);
		setIdCategory(builder.idCategory);
	}

	public static final class Builder
	{
		private int id;
		private String name;
		private int prepTime;
		private int prepCuisson;
		private int difficulty;
		private int idCategory;

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

		public Builder prepTime(int val)
		{
			prepTime = val;
			return this;
		}

		public Builder prepCuisson(int val)
		{
			prepCuisson = val;
			return this;
		}

		public Builder difficulty(int val)
		{
			difficulty = val;
			return this;
		}

		public Builder idCategory(int val)
		{
			idCategory = val;
			return this;
		}

		public Recipe build()
		{
			return new Recipe(this);
		}
	}
}
