package exercices.player_quest;

public class Main
{
	public static void main(String[] args)
	{
		Player player = new Player("Player");

		for (int i = 1; i <= 1000; i++)
		{
			System.out.printf("Player %s do quest %d %n", player.name, i);
			player.doQuest();
		}
	}
}
