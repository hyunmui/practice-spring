package com.flexibledev.java.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.flexibledev.java.domain.Customer;
import com.flexibledev.java.entity.CustomerEntity;
import com.flexibledev.java.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceTxTemplate implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceTxTemplate.class);
    
    @Resource(name = "customerRepository")
    private CustomerRepository repository;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public Customer getCustomer(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Customer> getCustomers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Customer> getCustomerByPage(int index, int size) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveCustomer(Customer customer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateCustomer(Customer customer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteCustomer(final long id) {
        transactionTemplate.execute(new TransactionCallback<Void>() {

            @Override
            public Void doInTransaction(TransactionStatus status) {
                try {
                    if (id == 0) {
                        List<CustomerEntity> customers = repository.findAll();
                        for (CustomerEntity customerEntity : customers) {
                            repository.delete(customerEntity.getId());
                        }
                    } else {
                        repository.delete(id);
                    }
                } catch (Exception e) {
                    logger.info("삭제를 취소하고 롤백합니다!!");
                    status.setRollbackOnly();
                }
                return null;
            }

        });
    }

    @Override
    public List<Customer> getCustomersByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

}
