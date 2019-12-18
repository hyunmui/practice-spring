package springHello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springHello.customer.CustomerService;
import springHello.customer.CustomerServiceImpl;

@Configuration
public class AppConfig {
	
	@Bean
	CustomerService customerService() {
		return new CustomerServiceImpl();
	}
	
}
