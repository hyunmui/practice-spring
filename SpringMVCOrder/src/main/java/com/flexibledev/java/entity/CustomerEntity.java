package com.flexibledev.java.entity;

import com.flexibledev.java.domain.Customer;

public class CustomerEntity {
	private long id;
	private String name;
	private String address;
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
	
	public void buildEntity(Customer customer) {
		id = customer.getId();
		name = customer.getName();
		address = customer.getAddress();
		email = customer.getEmail();
	}
}
