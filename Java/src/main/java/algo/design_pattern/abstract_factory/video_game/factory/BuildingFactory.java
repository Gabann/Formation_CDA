package algo.design_pattern.abstract_factory.video_game.factory;

import algo.design_pattern.abstract_factory.video_game.entity.AbstractBuildingBuilder;
import algo.design_pattern.abstract_factory.video_game.entity.Building;

public class BuildingFactory<T extends Building>
{
	public T createBuilding(AbstractBuildingBuilder<T> builder)
	{
		return builder.build();
	}
}
