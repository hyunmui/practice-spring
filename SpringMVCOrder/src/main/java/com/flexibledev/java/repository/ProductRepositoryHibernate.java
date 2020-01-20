package com.flexibledev.java.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flexibledev.java.entity.Pageable;
import com.flexibledev.java.entity.ProductEntity;

@Repository("productRepository")
public class ProductRepositoryHibernate implements ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public ProductEntity findOne(long id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String sql = "SELECT * FROM product WHERE product_id = :id";
		ProductEntity product = (ProductEntity)session.createSQLQuery(sql)
				.addEntity(ProductEntity.class)
				.setParameter("id", id)
				.uniqueResult();
		session.getTransaction().commit();
		return product;
	}

	@Override
	public List<ProductEntity> findAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String sql = "SELECT * FROM PRODUCT";
		List<ProductEntity> products = session.createSQLQuery(sql).addEntity(ProductEntity.class).list();
		session.getTransaction().commit();
		return products;
	}

	@Override
	public List<ProductEntity> findAll(Pageable page) {
		return null;
	}

	@Override
	public void save(ProductEntity product) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String sql = "INSERT INTO product (name, price, description) VALUES (:name, :price, :description)";
		session.createSQLQuery(sql)
			.setParameter("name", product.getName())
			.setParameter("price", product.getPrice())
			.setParameter("description", product.getDescription())
			.executeUpdate();
		
		String mysql = "SELECT LAST_INSERT_ID()";
		long id = (long)session.createSQLQuery(mysql).uniqueResult();
		product.setId(id);
		session.getTransaction().commit();
	}

	@Override
	public void update(ProductEntity product) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String sql = "UPDATE product SET name = :name, price = :price, description = :description WHERE product_id = :id";
		session.createSQLQuery(sql)
			.setParameter("name", product.getName())
			.setParameter("price", product.getPrice())
			.setParameter("description", product.getDescription())
			.setParameter("id", product.getId())
			.executeUpdate();
		session.getTransaction().commit();
	}
	
	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String sql = "DELETE FROM product WHERE product_id = :id";
		session.createSQLQuery(sql)
			.setParameter("id", id)
			.executeUpdate();
		session.getTransaction().commit();
	}

}
