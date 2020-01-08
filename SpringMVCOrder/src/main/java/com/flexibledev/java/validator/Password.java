package com.flexibledev.java.validator;

 import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
	String message() default "비밀번호가 틀렸습니다. 대문자와 특수문자, 숫자를 포함하여 6자 이상 20자까지 입력하세요.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
