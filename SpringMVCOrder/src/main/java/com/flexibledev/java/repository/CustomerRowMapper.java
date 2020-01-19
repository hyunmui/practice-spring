package com.flexibledev.java.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.flexibledev.java.entity.CustomerEntity;

public class CustomerRowMapper implements RowMapper<CustomerEntity> {

    @Override
    public CustomerEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(rs.getInt("customer_id"));
        entity.setName(rs.getString("name"));
        entity.setAddress(rs.getString("address"));
        entity.setEmail(rs.getString("email"));
        return entity;
    }

}
