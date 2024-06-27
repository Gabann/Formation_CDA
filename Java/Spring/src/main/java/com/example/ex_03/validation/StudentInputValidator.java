package com.example.ex_03.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StudentInputValidator implements ConstraintValidator<StudentInputValid, String>
{
	String requiredContainsString;

	@Override
	public void initialize(StudentInputValid constraintAnnotation)
	{
		this.requiredContainsString = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext)
	{
		return s.contains(requiredContainsString);
	}
}
