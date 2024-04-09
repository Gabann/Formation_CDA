package exercices;

public class Exercice30
{
	public static void playerQuest()
	{
		Player player = new Player("Player", 1, 0);

		for(int i = 0; i <= 21; i++)
		{
			System.out.printf("Player %s do quest %d %n", player.name, i);
			player.doQuest();
		}
	}
}
