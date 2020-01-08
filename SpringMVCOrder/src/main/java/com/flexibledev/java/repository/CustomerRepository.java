package com.flexibledev.java.repository;

import java.util.List;

import com.flexibledev.java.Pageable;
import com.flexibledev.java.entity.CustomerEntity;

public interface CustomerRepository {
	CustomerEntity findOne(long id);
	List<CustomerEntity> findAll();
	List<CustomerEntity> findAll(Pageable page);
	void save(CustomerEntity customer);
	void delete(long id);
}
