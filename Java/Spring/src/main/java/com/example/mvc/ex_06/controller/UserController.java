package com.example.mvc.ex_06.controller;

import com.example.mvc.ex_06.model.User;
import com.example.mvc.ex_06.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forum/user")
public class UserController
{
	private final UserService userService;

	@Autowired
	UserController(UserService userService)
	{
		this.userService = userService;
	}

	@GetMapping("/{id}")
	public String getById(@PathVariable Long id, Model model)
	{
		User user = userService.getById(id);

		if (user == null)
		{
			return "redirect:/error/404";
		}

		model.addAttribute("user", user);
		return "ex_06/secured/userDetails";

	}
}
