package com.flexibledev.java.controller.order;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.flexibledev.java.model.OrderModel;
import com.flexibledev.java.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RolesAllowed("ROLE_USER")
	public void purchaseOrder(OrderModel order) {
		orderService.purchaseOrder(order.buildDomain());
	}
}
