package com.flexibledev.java.repository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flexibledev.java.entity.CustomerEntity;
import com.flexibledev.java.entity.OrderEntity;
import com.flexibledev.java.entity.OrderItemEntity;
import com.flexibledev.java.entity.Pageable;
import com.flexibledev.java.entity.ProductEntity;

@Repository("orderRepository")
public class OrderRepositoryCriteria implements OrderRepository {

	private static final Logger logger = LoggerFactory.getLogger(OrderRepositoryCriteria.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public OrderEntity findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderEntity> findAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.getTransaction().commit();
		return null;
	}

	@Override
	public List<OrderEntity> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(OrderEntity order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(OrderEntity order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testOneAndOne() {

		printTest(() -> {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			String sqlAll = "select * from order_item";
			List<OrderItemEntity> items = session.createSQLQuery(sqlAll).addEntity(OrderItemEntity.class).list();

			for (OrderItemEntity entity : items) {
				logger.info(entity.toString());
			}
			transaction.commit();
		}, "SELECT ALL");
		
		printTest(() -> {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			String sqlUnique = "select * from order_item where order_item_id = :id";
			OrderItemEntity entity = (OrderItemEntity)session.createSQLQuery(sqlUnique).addEntity(OrderItemEntity.class).setLong("id", 1).uniqueResult();
			
			logger.info(entity.toString());
			
			transaction.commit();
		}, "SELECT UNIQUE");

		printTest(() -> {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			
			OrderItemEntity entity = new OrderItemEntity();
			ProductEntity product = (ProductEntity)session.createCriteria(ProductEntity.class).add(Restrictions.eq("id", 1L)).uniqueResult();
			entity.setProduct(product);
			entity.setAmount(1234122);
			session.save(entity);
			logger.info(entity.toString());
			transaction.commit();
			
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			entity.setAmount(9999999);
			session.update(entity);
			logger.info(entity.toString());
			transaction.commit();
			
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			entity.setAmount(9999999);
			session.delete(entity);
			logger.info("remove entity: " + entity.toString());
			transaction.commit();
			
		}, "INSERT / UPDATE / DELETE");
		
	}

	@Override
	public void testOneAndMany() {
		printTest(() -> {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			List<OrderEntity> orders = session.createCriteria(OrderEntity.class).list();

			for (OrderEntity entity : orders) {
				logger.info(entity.toString());
			}
			transaction.commit();
		}, "SELECT ALL");
		
		printTest(() -> {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			OrderEntity order = (OrderEntity)session.createCriteria(OrderEntity.class).add(Restrictions.eq("id", 1L)).uniqueResult();
			logger.info(order.toString());
			transaction.commit();
		}, "SELECT ONE");
		
		
		logger.info("--------------------- INSERT / UPDATE / DELTE ---------------------");
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		OrderEntity entity = new OrderEntity();
		entity.setOrderDate(new Date());
		entity.setItems(new HashSet<OrderItemEntity>());
		OrderItemEntity item1 = new OrderItemEntity();
		ProductEntity product1 = (ProductEntity)session.createCriteria(ProductEntity.class).add(Restrictions.eq("id", 1L)).uniqueResult();
		item1.setProduct(product1);
		item1.setAmount(44123124);
		entity.getItems().add(item1);
		OrderItemEntity item2 = new OrderItemEntity();
		ProductEntity product2 = (ProductEntity)session.createCriteria(ProductEntity.class).add(Restrictions.eq("id", 2L)).uniqueResult();
		item2.setProduct(product2);
		item2.setAmount(11111111);
		entity.getItems().add(item2);
		CustomerEntity customer = (CustomerEntity)session.createCriteria(CustomerEntity.class).add(Restrictions.eq("id", 1L)).uniqueResult();
		entity.setCustomer(customer);
		session.save(entity);
		logger.info(entity.toString());
		transaction.commit();
		
		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		entity.setOrderDate(new Date());
		OrderItemEntity item3 = new OrderItemEntity();
		ProductEntity product3 = (ProductEntity)session.createCriteria(ProductEntity.class).add(Restrictions.eq("id", 3L)).uniqueResult();
		item3.setProduct(product3);
		item3.setAmount(33333333);
		entity.getItems().add(item3);
		entity.getItems().remove(item1);
		session.update(entity);
		logger.info(entity.toString());
		transaction.commit();
		
//		session = sessionFactory.getCurrentSession();
//		transaction = session.beginTransaction();
//		session.delete(entity);
//		logger.info("remove entity: " + entity.toString());
//		transaction.commit();
		
		logger.info("------------------------------------------------------------");
		
	}

	private void printTest(PrintFunc func, String funcName) {
		logger.info("--------------------- " + funcName + " ---------------------");
		func.print();
		logger.info("------------------------------------------------------------");
	}

	@FunctionalInterface
	private interface PrintFunc {
		void print();
	}
}
