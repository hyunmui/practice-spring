package com.flexibledev.java.controller.order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flexibledev.java.domain.Product;
import com.flexibledev.java.model.CustomerModel;
import com.flexibledev.java.model.OrderItemModel;
import com.flexibledev.java.model.OrderModel;
import com.flexibledev.java.model.ProductModel;
import com.flexibledev.java.service.OrderService;
import com.flexibledev.java.service.ProductService;


@Controller
@RequestMapping(value="/")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class,  new CustomDateEditor(df, false));
	}
	@RequestMapping(value="create.do",  method=RequestMethod.GET)
	public String createOrder(Model model) {
		List<Product> products = productService.getProducts();
		List<ProductModel> productModels = convert(products);
		OrderModel order = new OrderModel();
		CustomerModel customer = new CustomerModel();
		customer.setId(1);
		customer.setName("전병선");
		customer.setAddress("서울시");
		customer.setEmail("bsjun@ensoa.co.kr");
		order.setCustomer(customer);
		order.setItems(new ArrayList<OrderItemModel>());
		model.addAttribute("order",  order);
		model.addAttribute("products", productModels);
		return "create";
	}
	
	private List<ProductModel> convert(List<Product> products ) {
		List<ProductModel> productModels = new ArrayList<ProductModel>();
		for(Product product : products) {
			ProductModel productModel = new ProductModel();
			productModel.buildModel(product);
			productModels.add(productModel);
		}
		return productModels;
	}
}