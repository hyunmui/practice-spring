package com.flexibledev.java.model;

import java.util.Date;
import java.util.List;

import com.flexibledev.java.domain.Order;

public class OrderModel {
	private long id;
	private Date orderDate;
	private CustomerModel customer;
	private List<OrderItemModel> items;
	
	public Order buildDomain() {
		return new Order();
	}
}
