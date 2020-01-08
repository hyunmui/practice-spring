package com.flexibledev.java.model;

import java.util.Date;
import java.util.List;

public class OrderModel {
	private long id;
	private Date orderDate;
	private CustomerModel customer;
	private List<OrderItemModel> items;
}
