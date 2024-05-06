package exercices.design_pattern.abstract_factory.video_game.entity.impl;

import exercices.design_pattern.abstract_factory.video_game.entity.AbstractBuildingBuilder;
import exercices.design_pattern.abstract_factory.video_game.entity.Building;

import java.util.ArrayList;
import java.util.List;

public class Forge extends Building
{
	List<String> weapons = new ArrayList<>();

	private Forge(ForgeBuilder forgeBuilder)
	{
		this.weapons = forgeBuilder.weapons;
	}


	@Override
	public String toString()
	{
		return "Forge{" +
				"weapons=" + weapons +
				", style='" + style + '\'' +
				", heightCentimeter=" + heightCentimeter +
				"} " + super.toString();
	}

	public static class ForgeBuilder extends AbstractBuildingBuilder
	{
		private List<String> weapons = new ArrayList<>();
		private String style;
		private int heightCentimeter;

		public ForgeBuilder weapons(List<String> weapons)
		{
			this.weapons = weapons;
			return this;
		}

		public ForgeBuilder style(String style)
		{
			this.style = style;
			return this;
		}

		public ForgeBuilder heightCentimeter(int heightCentimeter)
		{
			this.heightCentimeter = heightCentimeter;
			return this;
		}

		public Forge build()
		{
			Forge forge = new Forge(this);
			forge.style = this.style;
			forge.heightCentimeter = this.heightCentimeter;
			return forge;
		}
	}
}
