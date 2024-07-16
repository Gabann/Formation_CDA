package com.example.security.ex_01.controller;

import com.example.security.ex_01.dto.BaseResponseDto;
import com.example.security.ex_01.dto.UserLoginDto;
import com.example.security.ex_01.entity.User;
import com.example.security.ex_01.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController
{
	final UserService userService;

	public UserController(UserService userService)
	{
		this.userService = userService;
	}

	@PostMapping("/register")
	public BaseResponseDto register(@RequestBody User user)
	{
		if (userService.createUser(user))
		{
			return new BaseResponseDto("Success");
		}
		else
		{
			return new BaseResponseDto("Error");
		}
	}

	@PostMapping("login")
	public BaseResponseDto logIn(@RequestBody UserLoginDto userLoginDto)
	{
		if (!userService.doesUsernameExists(userLoginDto.getUsername()) ||
				!userService.verifyUser(userLoginDto.getUsername(), userLoginDto.getPassword()))
		{
			return new BaseResponseDto("Wrong email or password");
		}

		Map<String, Object> response = new HashMap<>();

		response.put("token", userService.generateToken(userLoginDto.getUsername(), userLoginDto.getPassword()));

		return new BaseResponseDto("Success", response);
	}
}
