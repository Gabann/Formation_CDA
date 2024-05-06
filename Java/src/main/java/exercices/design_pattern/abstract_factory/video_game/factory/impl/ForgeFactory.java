package exercices.design_pattern.abstract_factory.video_game.factory.impl;

import exercices.design_pattern.abstract_factory.video_game.entity.AbstractBuildingBuilder;
import exercices.design_pattern.abstract_factory.video_game.entity.impl.Forge;
import exercices.design_pattern.abstract_factory.video_game.factory.BuildingFactory;

public class ForgeFactory extends BuildingFactory
{
	@Override
	public Forge createBuilding(AbstractBuildingBuilder builder)
	{
		return (Forge) builder.build();
	}
}
