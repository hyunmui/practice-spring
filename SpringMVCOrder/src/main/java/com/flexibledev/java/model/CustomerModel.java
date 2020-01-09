package com.flexibledev.java.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.flexibledev.java.domain.Customer;

public class CustomerModel {
	private long id;
	@Size(min = 2, max = 10, message = "{validate.customer.name}")
	@Pattern(regexp = "^[A-Za-z0-9가-힣]+$", message = "{validate.customer.name.pattern}")
	private String name;
	@Size(max = 60, message = "{validate.customer.address}")
	private String address;
	@NotBlank(message = "{validate.customer.email}")
	@Email(message = "{validate.customer.email.correct}")
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
