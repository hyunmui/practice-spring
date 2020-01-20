package com.flexibledev.java.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		ProductEntity product = (ProductEntity)session.createCriteria(ProductEntity.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
		session.getTransaction().commit();
		return product;
	}

	@Override
	public List<ProductEntity> findAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<ProductEntity> products = session.createCriteria(ProductEntity.class).list();
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
		session.save(product);
		session.getTransaction().commit();
	}

	@Override
	public void update(ProductEntity product) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(product);;
		session.getTransaction().commit();
	}
	
	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(findOne(id));
		session.getTransaction().commit();
	}

}
