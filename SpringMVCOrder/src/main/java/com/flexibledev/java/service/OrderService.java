package com.flexibledev.java.service;

import com.flexibledev.java.domain.Order;

public interface OrderService {

	public void saveOrder(Order order);
	public void purchaseOrder(Order order);

}
