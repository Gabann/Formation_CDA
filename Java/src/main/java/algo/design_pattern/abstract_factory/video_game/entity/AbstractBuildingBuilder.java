package algo.design_pattern.abstract_factory.video_game.entity;

public abstract class AbstractBuildingBuilder<T extends Building>
{
	public abstract T build();
}
