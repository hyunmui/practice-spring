package com.flexibledev.java.repository;

import java.util.List;

import com.flexibledev.java.entity.CustomerEntity;
import com.flexibledev.java.entity.Pageable;

public interface CustomerRepository {
    CustomerEntity findOne(long id);
    CustomerEntity findOneByName(String name);
    List<CustomerEntity> findAll();
    List<CustomerEntity> findByName(String name);
    List<CustomerEntity> findAll(Pageable page);
    void save(CustomerEntity customer);
    void update(CustomerEntity customer);   
    void delete(long id);
}
