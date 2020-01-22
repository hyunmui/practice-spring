package com.flexibledev.java.service;

import java.util.List;

import com.flexibledev.java.domain.Customer;
import com.flexibledev.java.domain.Order;

public interface OrderService {

	void purchaseOrder(Order order);
	List<Order> getOrders(Customer customer);
	Order getOrder(long id);
	
	void testOneAndOne();
	void testOneAndMany();
}
