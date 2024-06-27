package com.example.ex_03.model;

import com.example.ex_03.validation.StudentInputValid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Student
{
	public static Map<Long, Student> studentMap = new HashMap<>();
	static Long studentCount = 0L;
	Long id;
	@StudentInputValid(value = "first", message = "Should contains 'first'")
	@NotNull
	String firstName;
	@NotNull
	String lastName;

	@Min(0)
	@Max(120)
	int age;
	@NotNull
	String email;

	public Student()
	{
		this.id = ++studentCount;
		studentMap.put(this.id, this);
	}

	public Student(String firstName, String lastName, int age, String email)
	{
		this.id = ++studentCount;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		studentMap.put(this.id, this);
	}

	@Override
	public String toString()
	{
		return "Student{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", age=" + age +
				", email='" + email + '\'' +
				'}';
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
}
