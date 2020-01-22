package com.flexibledev.java.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexibledev.java.domain.Product;
import com.flexibledev.java.entity.PageRequest;
import com.flexibledev.java.entity.Pageable;
import com.flexibledev.java.entity.ProductEntity;
import com.flexibledev.java.repository.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public Product getProduct(long id) {
		ProductEntity product = repository.findOne(id);
		return product.buildDomain();
	}

	@Override
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		List<ProductEntity> entities = repository.findAll();
		for (ProductEntity entity : entities) {
			Product product = entity.buildDomain();
			products.add(product);
		}
		return products;
	}

	@Override
	public List<Product> getProductsByPage(int index, int size) {
		Pageable page = new PageRequest(index, size);
		List<Product> products = new ArrayList<Product>();
		List<ProductEntity> entities = repository.findAll(page);
		for (ProductEntity entity : entities) {
			Product product = entity.buildDomain();
			products.add(product);
		}
		return products;
	}

	@Override
	public void saveProduct(Product product) {
		ProductEntity entity = new ProductEntity();
		entity.buildEntity(product);
		repository.save(entity);
	}

	@Override
	public void updateProduct(Product product) {
		ProductEntity entity = new ProductEntity();
		entity.buildEntity(product);
		repository.save(entity);
	}

	@Override
	public void deleteProduct(long id) {
		repository.delete(id);
	}

}
