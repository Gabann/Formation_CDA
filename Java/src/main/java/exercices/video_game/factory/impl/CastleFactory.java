package exercices.video_game.factory.impl;

import exercices.video_game.entity.AbstractBuildingBuilder;
import exercices.video_game.entity.impl.Castle;
import exercices.video_game.factory.BuildingFactory;

public class CastleFactory extends BuildingFactory
{
	@Override
	public Castle createBuilding(AbstractBuildingBuilder builder)
	{
		return (Castle) builder.build();
	}
}
