package com.flexibledev.java.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flexibledev.java.entity.CustomerEntity;
import com.flexibledev.java.entity.Pageable;

@Repository("customerRepository")
public class CustomerRepositoryHibernate implements CustomerRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public CustomerEntity findOne(long id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql = "from CustomerEntity where id = :id";
		CustomerEntity customer = (CustomerEntity) session.createQuery(hql).setParameter("id", id).uniqueResult();
		session.getTransaction().commit();
		return customer;
	}

	@Override
	public CustomerEntity findOneByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerEntity> findAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql = "from CustomerEntity";
		List<CustomerEntity> customers = session.createQuery(hql).list();
		session.getTransaction().commit();
		return customers;
	}

	@Override
	public List<CustomerEntity> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerEntity> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(CustomerEntity customer) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
	}

	@Override
	public void update(CustomerEntity customer) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String sql = "update CustomerEntity set name = :name, address = :address, email = :email where id = :id";
		session.createSQLQuery(sql)
			.setParameter("name", customer.getName())
			.setParameter("address", customer.getAddress())
			.setParameter("email", customer.getEmail())
			.setParameter("id", customer.getId())
			.executeUpdate();
		session.getTransaction().commit();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String sql = "delete CustomerEntity where id = :id";
		session.createSQLQuery(sql)
			.setParameter("id", id)
			.executeUpdate();
		session.getTransaction().commit();
	}

}
