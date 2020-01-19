package com.flexibledev.java.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flexibledev.java.entity.CustomerEntity;
import com.flexibledev.java.entity.Pageable;

//@Repository("customerRepository")
public class CustomerRepositoryJDBC implements CustomerRepository {

    @Autowired
    private DataSource dataSource;
    private Connection connection = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    
    private static final String SQL_GETALL = "select * from customer";
    private static final String SQL_GETBYNAME = "select * from customer where name = ?";
    private static final String SQL_INSERT = "insert into customer (name, address, email) values (?, ?, ?)";
    private static final String SQL_UPDATE = "update customer set name = ?, address = ?, email = ? where id = ?";
    private static final String SQL_DELETE = "delete from customer where id = ?";
    
    @Override
    public CustomerEntity findOne(long id) {
        CustomerEntity customer = new CustomerEntity();
        customer.setId(id);
        customer.setName("hyunmui");
        customer.setAddress("Incheon");
        customer.setEmail("hyunmui@outlook.kr");
        return customer;
    }

    @Override
    public List<CustomerEntity> findAll() {
        List<CustomerEntity> customers = new ArrayList<CustomerEntity>();
        try {
            connection = dataSource.getConnection();
            stmt = connection.prepareStatement(SQL_GETALL);
            rs = stmt.executeQuery();
            
            CustomerEntity customer = null;
            while (rs.next()) {
                customer = new CustomerEntity();
                customer.setId(rs.getInt("customer_id"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setEmail(rs.getString("email"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
                
                return customers;
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }

    @Override
    public List<CustomerEntity> findAll(Pageable page) {
        List<CustomerEntity> customers = new ArrayList<CustomerEntity>();
        int index = page.getIndex();
        int size = page.getSize();
        for (int i = 0; i < 10; i++) {
            CustomerEntity customer = new CustomerEntity();
            customer.setId(i);
            customer.setName("Name" + i);
            customer.setAddress("Address" + i);
            customer.setEmail("seon" + i + "@outlook.kr");
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public void save(CustomerEntity customer) {
        try {
            connection = dataSource.getConnection();
            stmt = connection.prepareStatement(SQL_INSERT);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getAddress());
            stmt.setString(3, customer.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    @Override
    public void update(CustomerEntity customer) {
        try {
            connection = dataSource.getConnection();
            stmt = connection.prepareStatement(SQL_UPDATE);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getAddress());
            stmt.setString(3, customer.getEmail());
            stmt.setLong(4, customer.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void delete(long id) {
        try {
            connection = dataSource.getConnection();
            stmt = connection.prepareStatement(SQL_DELETE);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public CustomerEntity findOneByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CustomerEntity> findByName(String name) {
        List<CustomerEntity> customers = new ArrayList<CustomerEntity>();
        try {
            connection = dataSource.getConnection();
            stmt = connection.prepareStatement(SQL_GETALL);
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            
            CustomerEntity customer = null;
            while (rs.next()) {
                customer = new CustomerEntity();
                customer.setId(rs.getInt("customer_id"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setEmail(rs.getString("email"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
                
                return customers;
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }

}
