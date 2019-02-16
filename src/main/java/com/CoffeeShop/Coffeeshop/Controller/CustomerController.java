package com.CoffeeShop.Coffeeshop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CoffeShop.Coffeeshop.model.Customer;
import com.CoffeeShop.Coffeeshop.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@GetMapping("/customer/{id}")
	public Customer get(@PathVariable int id) {
		return customerService.get(id);
	}
	@GetMapping("/customer")
	public List<Customer> getAll() {
		return customerService.getAll();
	}
	@PostMapping("/customer")
	public Customer add(@RequestBody Customer customer) {
		return customerService.add(customer);
	}
	@PutMapping("/customer")
	public Customer update(@RequestBody Customer customer) {
		return customerService.update(customer);
	}

	@DeleteMapping("/customer")
	public Customer delete(int id) {
		return customerService.delete(id);
	}
	
	
	
}
