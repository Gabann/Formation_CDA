package com.example.springsecurityjwt.dto;

import com.example.springsecurityjwt.model.Todo;
import lombok.Data;

@Data
public class TodoCreationDto
{
	Todo todo;
	Long userId;
}
