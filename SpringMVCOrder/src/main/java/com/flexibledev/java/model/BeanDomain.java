package com.flexibledev.java.model;

import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import com.flexibledev.java.validator.Password;

public class BeanDomain {
	// javax 검증 어노테이션
	@Digits(integer = 2, fraction = 0, message = "나이는 두자리 이상의 숫자를 갖지 못합니다.")
	@Min(value = 18, message = "최소값은 18 이어야 합니다.")
	@Max(value = 50, message = "최대값은 50 이상이 될 수 없습니다.")
	private int age;
	
	@NotNull(message = "이름을 입력해주십시오.")
	private String name;
	
	@DecimalMax(value = "99999.999", message = "숫자 값은 99999.999 이상이 될 수 없습니다.")
	@DecimalMin(value = "1.00", message = "숫자 값은 1.00 보다 작을 수 없습니다.")
	private float amount = 0f;
	
	@NotNull
	@Pattern(regexp = "^\\d{6}", message = "우편번호는 6 자리여야 합니다.")
	private String zipCode;
	
	// Hibernate 제공 검증 어노테이션
	@CreditCardNumber(message = "유효한 신용카드 번호를 입력해주십시오.")
	private String creditCard;
	
	@Email(message = "이메일을 잘못 입력하셨습니다.")
	private String email;
	
	@Length(max = 50, min = 10, message = "메시지는 10 문자 이상 50 문자까지 입력할 수 있습니다.")
	private String description;
	
	@NotBlank(message = "ID는 반드시 입력해야 합니다.")
	private String id;
	
	@NotEmpty(message = "제품 목록이 있어야합니다.")
	private List<String> productList;
	
	@URL(message = "유효한 웹 사이트 주소를 입력해주세요.")
	private String url;
	
	@Password
	private String password;
}
