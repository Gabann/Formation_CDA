package exercices.video_game.factory;

import exercices.video_game.entity.AbstractBuildingBuilder;
import exercices.video_game.entity.Building;

public class BuildingFactory<T extends Building>
{
	public T createBuilding(AbstractBuildingBuilder<T> builder)
	{
		return builder.build();
	}
}
