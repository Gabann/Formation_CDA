package exercices.video_game;

import exercices.video_game.entity.impl.Castle;
import exercices.video_game.entity.impl.Forge;
import exercices.video_game.factory.BuildingFactory;

public class Main
{
	public static void main(String[] args)
	{

		Castle castle = new BuildingFactory<Castle>().createBuilding(new Castle.CastleBuilder().name("My Castle"));
		Forge forge = new BuildingFactory<Forge>().createBuilding(new Forge.ForgeBuilder().style("My Forge"));

		System.out.println(castle);
		System.out.println(forge);
	}
}
