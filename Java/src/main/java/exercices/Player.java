package exercices;

public class Player
{
	String name;
	int level;
	double experiencePoints;

	public Player(String name, int level, double experiencePoints)
	{
		this.name = name;
		this.level = level;
		this.experiencePoints = experiencePoints;
	}

	private String getName()
	{
		return name;
	}

	private void setName(String name)
	{
		this.name = name;
	}

	private double getExperiencePoints()
	{
		return experiencePoints;
	}

	private void setExperiencePoints(double experiencePoints)
	{
		this.experiencePoints = experiencePoints;
	}

	private int getLevel()
	{
		return level;
	}

	private void setLevel(int level)
	{
		this.level = level;
	}

	void doQuest()
	{
		this.experiencePoints += 10;

		if(experiencePoints > 100)
		{
			incrementLevel();
			this.experiencePoints = 0;
		}
	}

	void incrementLevel()
	{
		this.setLevel(this.level + 1);
		System.out.printf("Player level up to level %d %n", this.level);
	}
}
