package exercices.video_game.factory.impl;

import exercices.video_game.entity.AbstractBuildingBuilder;
import exercices.video_game.entity.impl.Forge;
import exercices.video_game.factory.BuildingFactory;

public class ForgeFactory extends BuildingFactory
{
	@Override
	public Forge createBuilding(AbstractBuildingBuilder builder)
	{
		return (Forge) builder.build();
	}
}
