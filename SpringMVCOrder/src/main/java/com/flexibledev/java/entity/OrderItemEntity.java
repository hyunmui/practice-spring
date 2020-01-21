package com.flexibledev.java.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.flexibledev.java.domain.Order;
import com.flexibledev.java.domain.OrderItem;

public class OrderItemEntity {
	private long id;
	private int amount;
	private ProductEntity product;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public String toString() {
		return "id : " + id + ", amount : " + amount + ", product : " + product;
	}

	public OrderItem buildDomain() {
		OrderItem item = new OrderItem();
		item.setId(id);
		item.setAmount(amount);
		item.setProduct(product.buildDomain());
		return item;
	}

	public void buildEntity(OrderItem item) {
		id = item.getId();
		amount = item.getAmount();
		product = new ProductEntity();
		product.buildEntity(item.getProduct());
	}
}
