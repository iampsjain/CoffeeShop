package com.CoffeeShop.Coffeeshop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RestController;

import com.CoffeShop.Coffeeshop.model.Customer;
import com.CoffeeShop.Coffeeshop.repo.CustomerRepo;
@EntityScan("com.CoffeShop.Coffeeshop.model")
@RestController
public class LoginController {
	@Autowired
	CustomerRepo customerRepo;
	
	public String test() {
		Customer c=new Customer();
		c.setName("darshaan");
		customerRepo.save(c);
		return "Project is workaing1";
	}
}
