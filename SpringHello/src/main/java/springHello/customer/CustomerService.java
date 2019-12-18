package springHello.customer;

import java.util.List;

public interface CustomerService {
	Customer getCustomer(long id);
	List<Customer> getCustomers();
	List<Customer> getCustomerByPage(int index, int size);
	void saveCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(long id);
}
