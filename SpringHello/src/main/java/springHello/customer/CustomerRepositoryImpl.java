package springHello.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import springHello.common.Pageable;

public class CustomerRepositoryImpl implements CustomerRepository {

	private Properties properties;
	
	public void setProperties(Properties properties) {
		this.properties = properties;
		
		// example
		
		String driverClassName = this.properties.getProperty("driverClassName");
		String url = this.properties.getProperty("url");
		String username = this.properties.getProperty("username");
		String password = this.properties.getProperty("password");
	}

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
		System.out.println(customer + " was updated.");
	}

	@Override
	public void delete(long id) {
		CustomerEntity customer = findOne(id);
		System.out.println(customer + " was deleted");

	}

}
