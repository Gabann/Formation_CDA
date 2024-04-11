package exercices;

public class Exercice30
{
	public static void playerQuest()
	{
		Player player = new Player("Player");

		for(int i = 1; i <= 1000; i++)
		{
			System.out.printf("Player %s do quest %d %n", player.name, i);
			player.doQuest();
		}
	}
}
