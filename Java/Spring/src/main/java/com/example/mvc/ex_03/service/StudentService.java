package com.example.mvc.ex_03.service;

import com.example.mvc.ex_03.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
	public StudentService()
	{
		Student student1 = new Student("firstName1", "lastName1", 1, "email1");
		Student student2 = new Student("firstName2", "lastName2", 2, "email2");
	}

	public List<Student> getAllStudents()
	{
		return Student.studentMap.values()
				.stream()
				.toList();
	}

	public List<Student> filterByName(String name)
	{
		return Student.studentMap.values()
				.stream()
				.filter(student -> student.getFirstName().toLowerCase().contains(name.toLowerCase()))
				.toList();
	}

	public Student getById(Long id)
	{
		return Student.studentMap.get(id);
	}
}
