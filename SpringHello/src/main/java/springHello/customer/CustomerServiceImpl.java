package springHello.customer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource(name = "customerRepository")
	private CustomerRepository repository;

	public void setRepository(CustomerRepository repository) {
		this.repository = repository;
	}

	@Override
	public Customer getCustomer(long id) {
		CustomerEntity entity = repository.findOne(id);
		Customer customer = entity.buildDomain();
//		Customer customer = new Customer();
//		customer.setId(id);
//		customer.setName("hyunmui");
//		customer.setEmail("hyunmui@outlook.kr");
		return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setId(i);
			customer.setName("Name" + i);
			customer.setAddress("Address" + i);
			customer.setEmail("seon" + i + "@outlook.kr");
			customers.add(customer);
		}
		return customers;
	}

	@Override
	public List<Customer> getCustomerByPage(int index, int size) {
		List<Customer> customers = new ArrayList<Customer>();
		for (int i = index; i < index + size; i++) {
			Customer customer = new Customer();
			customer.setId(i);
			customer.setName("Name" + i);
			customer.setAddress("Address" + i);
			customer.setEmail("seon" + i + "@outlook.kr");
			customers.add(customer);
		}
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		System.out.println(customer + " was saved.");
	}

	@Override
	public void updateCustomer(Customer customer) {
		System.out.println(customer + " was updated.");
	}

	@Override
	public void deleteCustomer(long id) {
		Customer customer = getCustomer(id);
		System.out.println(customer + " was deleted.");
	}

	@PostConstruct
	public void init() {
		System.out.println("Create instance...");
	}

	@PreDestroy
	public void cleanUp() {
		System.out.println("Destroy instance...");
	}

}
