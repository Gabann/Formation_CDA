package com.example.springsecurityjwt.controller;


import com.example.springsecurityjwt.dto.BaseResponseDto;
import com.example.springsecurityjwt.dto.UserLoginDto;
import com.example.springsecurityjwt.dto.UserRegistrationDto;
import com.example.springsecurityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	UserService userService;

	@PostMapping("/register")
	public BaseResponseDto registerUser(@RequestBody UserRegistrationDto userRegistrationDto)
	{

		if (userService.createUser(userRegistrationDto))
		{
			return new BaseResponseDto("Success");
		}
		else
		{
			return new BaseResponseDto("Failed");
		}
	}

	@PostMapping("/login")
	public BaseResponseDto loginUser(@RequestBody UserLoginDto userLoginDto)
	{

		if (userService.checkUserNameExists(userLoginDto.getEmail()))
		{

			if (userService.verifyUser(userLoginDto.getEmail(), userLoginDto.getPassword()))
			{

				Map<String, Object> data = new HashMap<>();

				data.put("token", userService.generateToken(userLoginDto.getEmail(), userLoginDto.getPassword()));

				return new BaseResponseDto("Success", data);

			}
			else
			{
				return new BaseResponseDto("Wrong password");
			}

		}
		else
		{
			return new BaseResponseDto("User Not Exist");
		}


	}


}
