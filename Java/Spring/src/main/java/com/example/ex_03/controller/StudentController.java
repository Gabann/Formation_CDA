package com.example.ex_03.controller;

import com.example.ex_03.model.Student;
import com.example.ex_03.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController
{
	private final StudentService studentService;

	public StudentController(StudentService studentService)
	{
		this.studentService = studentService;
	}

	@GetMapping("/student/getAll")
	public String getAll(Model model)
	{
		model.addAttribute("studentList", studentService.getAllStudents());

		return "ex_03/allStudents";
	}

	@GetMapping("/student/studentDetails")
	public String getById(@RequestParam(name = "studentId", required = true) Long id, Model model)
	{
		model.addAttribute("student", studentService.getById(id));

		return "ex_03/studentDetails";
	}

	@GetMapping("/student/filterByName")
	public String getByName(@RequestParam(name = "studentName", required = true) String studentName, Model model)
	{
		model.addAttribute("studentList", studentService.filterByName(studentName));

		return "ex_03/filterByName";
	}

	@GetMapping("student/add")
	public String addStudent(Model model)
	{
		model.addAttribute("student", new Student());
		return "ex_03/addStudent";
	}

	@PostMapping("student/add")
	public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			System.out.println("form has errors");
			return "error/404";
		}

		System.out.println(student);
		return "redirect:/student/getAll";
	}
}
