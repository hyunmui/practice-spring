package com.flexibledev.java.service;

import java.util.List;

import com.flexibledev.java.domain.Customer;

public interface CustomerService {
	Customer getCustomer(long id);
	List<Customer> getCustomers();
	List<Customer> getCustomerByPage(int index, int size);
	void saveCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(long id);
	List<Customer> getCustomersByName(String name);
}
