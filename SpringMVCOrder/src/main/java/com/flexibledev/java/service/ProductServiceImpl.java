package com.flexibledev.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flexibledev.java.domain.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Override
	public Product getProduct(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByPage(int index, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		
	}

}
