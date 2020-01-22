package com.flexibledev.java.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.flexibledev.java.domain.Customer;

@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "root.customer_seq")
    @Column(name = "customer_id")
    private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "email")
	private String email;
	@OneToMany(mappedBy = "customer")
	private Set<OrderEntity> orders;

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
