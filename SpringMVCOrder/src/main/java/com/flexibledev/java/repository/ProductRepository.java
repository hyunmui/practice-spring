package com.flexibledev.java.repository;

import java.util.List;

import com.flexibledev.java.entity.Pageable;
import com.flexibledev.java.entity.ProductEntity;

public interface ProductRepository {
	ProductEntity findOne(long id);
	List<ProductEntity> findAll();
	List<ProductEntity> findAll(Pageable page);
	void save(ProductEntity product);
	void update(ProductEntity product);
	void delete(long id);
}
