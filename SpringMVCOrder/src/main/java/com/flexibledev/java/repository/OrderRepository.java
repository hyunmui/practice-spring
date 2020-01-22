package com.flexibledev.java.repository;

import java.util.List;

import com.flexibledev.java.entity.OrderEntity;
import com.flexibledev.java.entity.Pageable;

public interface OrderRepository {
	OrderEntity findOne(long id);
	List<OrderEntity> findAll();
	List<OrderEntity> findAll(Pageable page);
	void save(OrderEntity order);
	void update(OrderEntity order);
	void delete(long id);
	
	void testOneAndOne();
	void testOneAndMany();
}
