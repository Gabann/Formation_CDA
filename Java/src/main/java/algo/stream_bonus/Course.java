package algo.stream_bonus;

public class Course
{
	private final int id;
	private final String name;
	private final Teacher teacher;
	private final int duration;

	public Course(int id, String name, Teacher teacher, int duration)
	{
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.duration = duration;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public Teacher getTeacher()
	{
		return teacher;
	}

	public int getDuration()
	{
		return duration;
	}

	@Override
	public String toString()
	{
		return "Course{" +
				"id=" + id +
				", name='" + name + '\'' +
				", teacher=" + teacher +
				", duration=" + duration +
				'}';
	}
}
