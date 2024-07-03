package com.example.ex_06.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forum")
public class LogInController
{
	@PostMapping("login")
	String postLogIn()
	{
		System.out.println("Login");
		return "ex_06/login";
	}

	@GetMapping("login")
	String logIn()
	{
		return "ex_06/login";
	}

	@GetMapping("/secured")
	public String testSecured()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(authentication);
		System.out.println(currentPrincipalName);
		return "ex_06/secured/test";
	}
}
