package com.flexibledev.java.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.flexibledev.java.domain.Order;
import com.flexibledev.java.domain.OrderItem;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @Column(name = "order_id")
	private long id;
    @Column(name = "order_date")
	private Date orderDate;
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	@OrderBy("id asc")
	@OrderColumn(name = "idx")
	private Set<OrderItemEntity> items;
	@JoinColumn(name = "customer_id")
	@ManyToOne(cascade = { CascadeType.ALL })
	private CustomerEntity customer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public Set<OrderItemEntity> getItems() {
		return items;
	}

	public void setItems(Set<OrderItemEntity> items) {
		this.items = items;
	}

	public String toString() {
		String result = "id : " + id + ", orderDate : " + orderDate + "\n";
		for (OrderItemEntity item : items)
			result += item.toString() + "\n";
		return result;
	}

	public Order buildDomain() {
		Order order = new Order();
		order.setId(id);
		order.setOrderDate(orderDate);
		order.setCustomer(customer.buildDomain());
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for (OrderItemEntity item : items)
			orderItems.add(item.buildDomain());
		order.setItems(orderItems);
		return order;
	}

	public void buildEntity(Order order) {
		id = order.getId();
		orderDate = order.getOrderDate();
		customer = new CustomerEntity();
		customer.buildEntity(order.getCustomer());
		items = new HashSet<OrderItemEntity>();
		for (OrderItem orderItem : order.getItems()) {
			OrderItemEntity item = new OrderItemEntity();
			item.buildEntity(orderItem);
			items.add(item);
		}
	}
}
