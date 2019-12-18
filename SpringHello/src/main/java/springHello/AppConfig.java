package springHello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import springHello.customer.CustomerService;
import springHello.customer.CustomerServiceImpl;

@Configuration
public class AppConfig {
	
	@Bean(name = "customerService", initMethod = "init", destroyMethod = "cleanUp")
	@Scope("prototype")
	CustomerService customerService() {
		return new CustomerServiceImpl();
	}
	
}
