package com.CoffeeShop.Coffeeshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CoffeShop.Coffeeshop.model.Address;
import com.CoffeShop.Coffeeshop.model.Billing;
import com.CoffeShop.Coffeeshop.model.Customer;

@Service
public interface CustomerService {
	public Customer get(int id);

	public List<Customer> getAll();

	public Customer add(Customer customer);

	
	public Customer delete(int id);
}
