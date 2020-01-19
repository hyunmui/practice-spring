package com.flexibledev.java.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.flexibledev.java.entity.CustomerEntity;
import com.flexibledev.java.entity.Pageable;

@Repository("customerRepository")
public class CustomerRepositoryJdbcTemplate implements CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SQL_GETALL = "select * from customer";
    private static final String SQL_GETONE = "select * from customer where customer_id = ?";
    private static final String SQL_GETONEBYNAME = "select * from customer where name = ? limit 1";
    private static final String SQL_GETBYNAME = "select * from customer where name = ?";
    private static final String SQL_INSERT = "insert into customer (name, address, email) values (?, ?, ?)";
    private static final String SQL_UPDATE = "update customer set name = ?, address = ?, email = ? where customer_id = ?";
    private static final String SQL_DELETE = "delete from customer where customer_id = ?";

    @Override
    public CustomerEntity findOne(long id) {
        return jdbcTemplate.queryForObject(SQL_GETONE, new Object[] { id }, new RowMapper<CustomerEntity>() {

            @Override
            public CustomerEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                CustomerEntity entity = new CustomerEntity();
                entity.setId(rs.getInt("customer_id"));
                entity.setName(rs.getString("name"));
                entity.setAddress(rs.getString("address"));
                entity.setEmail(rs.getString("email"));
                return entity;
            }

        });
    }

    @Override
    public CustomerEntity findOneByName(String name) {
        return jdbcTemplate.queryForObject(SQL_GETONEBYNAME, new Object[] { name }, new RowMapper<CustomerEntity>() {

            @Override
            public CustomerEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                CustomerEntity entity = new CustomerEntity();
                entity.setId(rs.getInt("customer_id"));
                entity.setName(rs.getString("name"));
                entity.setAddress(rs.getString("address"));
                entity.setEmail(rs.getString("email"));
                return entity;
            }

        });
    }

    @Override
    public List<CustomerEntity> findAll() {
        return jdbcTemplate.query(SQL_GETALL, new RowMapper<CustomerEntity>() {

            @Override
            public CustomerEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                CustomerEntity entity = new CustomerEntity();
                entity.setId(rs.getInt("customer_id"));
                entity.setName(rs.getString("name"));
                entity.setAddress(rs.getString("address"));
                entity.setEmail(rs.getString("email"));
                return null;
            }

        });
    }

    @Override
    public List<CustomerEntity> findByName(String name) {
        return jdbcTemplate.query(SQL_GETBYNAME, new Object[] { name }, new RowMapper<CustomerEntity>() {

            @Override
            public CustomerEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                CustomerEntity entity = new CustomerEntity();
                entity.setId(rs.getInt("customer_id"));
                entity.setName(rs.getString("name"));
                entity.setAddress(rs.getString("address"));
                entity.setEmail(rs.getString("email"));
                return null;
            }

        });
    }

    @Override
    public List<CustomerEntity> findAll(Pageable page) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(CustomerEntity customer) {
        jdbcTemplate.update(SQL_INSERT, customer.getName(), customer.getAddress(), customer.getEmail());

    }

    @Override
    public void update(CustomerEntity customer) {
        jdbcTemplate.update(SQL_UPDATE, customer.getName(), customer.getAddress(), customer.getEmail());

    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update(SQL_DELETE, id);
    }

}
