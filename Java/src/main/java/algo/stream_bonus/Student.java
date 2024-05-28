package algo.stream_bonus;

import java.util.ArrayList;
import java.util.List;

public class Student
{
	private static int studentCount = 0;
	private final int id;
	private final String name;
	private final int age;
	private final List<Course> courses;

	public Student(String name, int age)
	{
		this.id = ++studentCount;
		this.name = name;
		this.age = age;
		this.courses = new ArrayList<>();
	}

	public static int getStudentCount()
	{
		return studentCount;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}

	public List<Course> getCourses()
	{
		return courses;
	}

	public void addCourse(Course course)
	{
		this.courses.add(course);
	}

	@Override
	public String toString()
	{
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
