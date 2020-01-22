package com.flexibledev.java.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexibledev.java.domain.Customer;
import com.flexibledev.java.domain.Order;
import com.flexibledev.java.entity.CustomerEntity;
import com.flexibledev.java.entity.OrderEntity;
import com.flexibledev.java.repository.CustomerRepository;
import com.flexibledev.java.repository.OrderRepository;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repository;
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void purchaseOrder(Order order) {
		OrderEntity entity = new OrderEntity();
		entity.buildEntity(order);
		CustomerEntity customer = customerRepository.findOne(entity.getCustomer().getId());
		entity.setCustomer(customer);
		repository.save(entity);
	}

	@Override
	public List<Order> getOrders(Customer customer) {
		List<Order> orders = new ArrayList<Order>();
		List<OrderEntity> entities = repository.findAll();
		for(OrderEntity entity : entities) {
			Order order = entity.buildDomain();
			orders.add(order);
		}
		return orders;
	}

	@Override
	public Order getOrder(long id) {
		OrderEntity entity = repository.findOne(id);
		return entity.buildDomain();
	}

	@Override
	public void testOneAndOne() {
		repository.testOneAndOne();
	}

	@Override
	public void testOneAndMany() {
		repository.testOneAndMany();
	}

}
