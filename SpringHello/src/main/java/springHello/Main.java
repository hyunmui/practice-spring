package springHello;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springHello.autowire.Bean1;
import springHello.autowire.Bean2;
import springHello.autowire.Bean3;
import springHello.customer.Customer;
import springHello.customer.CustomerService;

public class Main {

	public static void main(String[] args) {
		// with classpath
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//		Hello hello = (Hello) ctx.getBean("hello");
//		String message = hello.sayHello("hyunmui");
//		System.out.println(message);
		
		String beanName = "customerService";
		testSpringHello(ctx, beanName);
		
		// with annotation
//		ApplicationContext annotationCtx = new AnnotationConfigApplicationContext(AppConfig.class);
//		testSpringHello(annotationCtx, beanName);
		
		// autowired test
//		ApplicationContext ctx2 = new ClassPathXmlApplicationContext("autowire_bean.xml");
//		Bean1 bean1 = (Bean1)ctx2.getBean("bean11");
//		Bean1 bean12 = (Bean1)ctx2.getBean("bean12");
//		Bean2 bean2 = (Bean2)ctx2.getBean("bean2");
//		Bean3 bean3 = (Bean3)ctx2.getBean("bean3");
//		
//		System.out.println(bean1);
//		System.out.println(bean12);
//		System.out.println(bean2);
//		System.out.println(bean2.getBean1());
//		System.out.println(bean3);
	}
	
	private static void testSpringHello(ApplicationContext ctx, String beanName) {
		CustomerService customerService = (CustomerService)ctx.getBean(beanName);
		
		List<Customer> customers = customerService.getCustomers();
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		
		System.out.println("-------------------------------");
		
		customers = customerService.getCustomerByPage(3, 5);
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		
		System.out.println("-------------------------------");
		
		Customer customer = customerService.getCustomer(1);
		System.out.println(customer);
		customer = new Customer();
		customer.setId(1);
		customer.setName("hyunmui");
		customer.setAddress("Incheon");
		customer.setEmail("hyunmui@naver.com");
		customerService.saveCustomer(customer);
		customer.setName("Martin");
		customerService.updateCustomer(customer);
		customerService.deleteCustomer(customer.getId());
	}

}
