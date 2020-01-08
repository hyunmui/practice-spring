package com.flexibledev.java.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.flexibledev.java.domain.Customer;

public class CustomerModel {
	private long id;
	@Size(min = 2, max = 10, message = "이름은 자 이상 10자까지입니다.")
	@Pattern(regexp = "^[A-Za-z0-9]+$", message = "공백문자 없이 숫자와 문자만 입력하세요.")
	private String name;
	@Size(max = 60, message = "주소는 60자까지 입력할 수 있습니다.")
	private String address;
	@Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "정확한 이메일 주소를 입력하세요.")
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("id: %s / name: %s / address: %s / email: %s", id, name, address, email);
	}

	public Customer buildDomain() {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setAddress(address);
		customer.setEmail(email);
		return customer;
	}

	public void buildModel(Customer customer) {
		id = customer.getId();
		name = customer.getName();
		address = customer.getAddress();
		email = customer.getEmail();
	}
}
