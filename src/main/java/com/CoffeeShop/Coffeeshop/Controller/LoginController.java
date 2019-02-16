package com.CoffeeShop.Coffeeshop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CoffeShop.Coffeeshop.model.Customer;
import com.CoffeeShop.Coffeeshop.repo.CustomerRepo;
import com.CoffeeShop.Coffeeshop.service.CustomerService;

@RestController
public class LoginController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/validate")
	public Customer validate(@RequestBody Customer customer) {
		return customerService.validateCustomer(customer);
	}
	
}
