package com.CoffeeShop.Coffeeshop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CoffeShop.Coffeeshop.model.Product;
import com.CoffeeShop.Coffeeshop.service.CustomerPaginationService;

@RestController
public class productpaginationcontroller {

	@Autowired
	private CustomerPaginationService customerService;
 
	@RequestMapping("/save")
	public String process() {
				return "Done";
	}
 
	@RequestMapping("/findall")
	public String findAll() {
		String result = "<html>";
 
		for (Product customer : customerService.findAllCustomers()) {
			result += customer.toString() + "br/";
		}
 
		return result + "</html>";
	}
 
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public List<Product> viewCustomers(@RequestParam(name = "p", defaultValue = "1") int pageNumber) {
		String result = "<html>";
 
		List<Product> customers = customerService.getPage(pageNumber);
 
		
 
		return customers;
	}
 
}
