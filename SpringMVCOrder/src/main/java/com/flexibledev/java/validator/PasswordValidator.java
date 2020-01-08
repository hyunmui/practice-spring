package com.flexibledev.java.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

	/**
	 * 정규식
	 * 1. 전체 길이는 6에서 20 문자임
	 * 2. 하나의 @, {@link #clone()}, $, % 와 같은 특수문자를 포함해야 함
	 * 3. 하나의 대문자와 소문자를 포함해야 함
	 * 4. 하나의 숫자를 포함해야 함
	 */
	private String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[@#$%]).{6, 20})";
	
	@Override
	public void initialize(Password pwd) {

	}

	@Override
	public boolean isValid(String str, ConstraintValidatorContext ctx) {
		return validate(str);
	}

	private boolean validate(final String password) {
		Matcher matcher;
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(password);
		return matcher.matches();
	}

}
