package com.flexibledev.java.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flexibledev.java.entity.CustomerEntity;
import com.flexibledev.java.entity.Pageable;

@Repository("customerRepository")
public class CustomerRepositoryJPQL implements CustomerRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public CustomerEntity findOne(long id) {
        return entityManager.find(CustomerEntity.class, id);
    }

    @Override
    public CustomerEntity findOneByName(String name) {
//		String jpql = "from SELECT c FROM CustomerEntity c where c.name = :name";
//		return entityManager.createQuery(jpql, CustomerEntity.class).setParameter("name", name).getSingleResult();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerEntity> criteria = builder.createQuery(CustomerEntity.class);
        Root<CustomerEntity> root = criteria.from(CustomerEntity.class);    // select
        Path<CustomerEntity> path = root.get("name");
        Predicate predicate = builder.equal(path, name);                    // where

        criteria.select(root).where(predicate);
        return entityManager.createQuery(criteria).getSingleResult();       // get data
    }

    @Override
    public List<CustomerEntity> findAll() {
        return entityManager.createQuery("from SELECT c FROM CustomerEntity c", CustomerEntity.class).getResultList();
    }

    @Override
    public List<CustomerEntity> findByName(String name) {
        String jpql = "from SELECT c FROM CustomerEntity c where c.name = :name";
        return entityManager.createQuery(jpql, CustomerEntity.class).setParameter("name", name).getResultList();
    }

    @Override
    public List<CustomerEntity> findAll(Pageable page) {
        return null;
    }

    @Override
    public void save(CustomerEntity customer) {
        entityManager.getTransaction().begin();

        entityManager.persist(customer);

        entityManager.getTransaction().commit();
    }

    @Override
    public void update(CustomerEntity customer) {
        entityManager.getTransaction().begin();

        CustomerEntity entity = findOne(customer.getId());
        entity.setName(customer.getName());
        entity.setAddress(customer.getAddress());
        entity.setEmail(customer.getEmail());

        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(long id) {
        entityManager.getTransaction().begin();

        entityManager.remove(findOne(id));

        entityManager.getTransaction().commit();
    }

}
