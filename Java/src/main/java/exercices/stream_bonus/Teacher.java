package exercices.stream_bonus;

public class Teacher
{
	private static int teacherCount = 0;

	private final int id;
	private final String name;
	private final String department;
	private final int startDate;

	public Teacher(String name, String department, int startDate)
	{
		this.id = ++teacherCount;
		this.name = name;
		this.department = department;
		this.startDate = startDate;
	}

	public static int getTeacherCount()
	{
		return teacherCount;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getDepartment()
	{
		return department;
	}

	public int getStartDate()
	{
		return startDate;
	}

	@Override
	public String toString()
	{
		return "Teacher{" +
				"id=" + id +
				", name='" + name + '\'' +
				", department='" + department + '\'' +
				", startDate=" + startDate +
				'}';
	}
}
