package springHello.customer;

import java.util.List;

import springHello.common.Pageable;

public interface CustomerRepository {
	CustomerEntity findOne(long id);
	List<CustomerEntity> findAll();
	List<CustomerEntity> findAll(Pageable page);
	void save(CustomerEntity customer);
	void delete(long id);
}
