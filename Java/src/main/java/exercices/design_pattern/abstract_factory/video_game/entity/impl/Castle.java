package exercices.design_pattern.abstract_factory.video_game.entity.impl;

import exercices.design_pattern.abstract_factory.video_game.entity.AbstractBuildingBuilder;
import exercices.design_pattern.abstract_factory.video_game.entity.Building;

public class Castle extends Building
{
	String name;

	private Castle(CastleBuilder castleBuilder)
	{
		this.name = castleBuilder.name;
	}

	@Override
	public String toString()
	{
		return "Castle{" +
				"name='" + name + '\'' +
				"} " + super.toString();
	}

	public static class CastleBuilder extends AbstractBuildingBuilder<Castle>
	{
		private String name;
		private String style;
		private int heightCentimeter;

		public CastleBuilder name(String name)
		{
			this.name = name;
			return this;
		}

		public CastleBuilder style(String style)
		{
			this.style = style;
			return this;
		}

		public CastleBuilder heightCentimeter(int heightCentimeter)
		{
			this.heightCentimeter = heightCentimeter;
			return this;
		}

		@Override
		public Castle build()
		{
			Castle castle = new Castle(this);
			castle.style = this.style;
			castle.heightCentimeter = this.heightCentimeter;
			return castle;
		}
	}
}
