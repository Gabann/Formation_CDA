package exercices;

public class Player
{
	static final int XP_FORMULA_FINAL = 100;
	String name;
	int level;
	double experiencePoints;

	public Player(String name)
	{
		this.name = name;
		this.level = 1;
		this.experiencePoints = 0;
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

		if(this.experiencePoints > (XP_FORMULA_FINAL) * getLevel() * 1.1)
		{
			incrementLevel();
			this.experiencePoints = 0;
		}
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
		this.setExperiencePoints(getExperiencePoints() + 10);
	}

	void incrementLevel()
	{
		this.setLevel(this.level + 1);
		System.out.printf("Player level up to level %d %n", this.level);
	}
}
