package exercices.design_pattern.abstract_factory.video_game.factory.impl;

import exercices.design_pattern.abstract_factory.video_game.entity.AbstractBuildingBuilder;
import exercices.design_pattern.abstract_factory.video_game.entity.impl.Castle;
import exercices.design_pattern.abstract_factory.video_game.factory.BuildingFactory;

public class CastleFactory extends BuildingFactory
{
	@Override
	public Castle createBuilding(AbstractBuildingBuilder builder)
	{
		return (Castle) builder.build();
	}
}
