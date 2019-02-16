package com.CoffeeShop.Coffeeshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CoffeShop.Coffeeshop.model.Address;
import com.CoffeShop.Coffeeshop.model.Billing;
import com.CoffeShop.Coffeeshop.model.Customer;
import com.CoffeShop.Coffeeshop.model.Product;
import com.CoffeeShop.Coffeeshop.repo.CustomerRepo;
import com.CoffeeShop.Coffeeshop.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepo customerRepo;

	@Override
	public Customer get(int id) {
		return customerRepo.getCustomerById(id);
	}

	@Override
	public List<Customer> getAll() {
		return customerRepo.findAll();
	}

	@Override
	public Customer add(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		Customer c = customerRepo.getOne(customer.getId());
		if (c == null) {
			return new Customer();
		}
		c.setName(customer.getName());
		c.setPassword(customer.getPassword());
		c.setRole(customer.getRole());
		c.setSurname(customer.getSurname());
		c.setUsername(customer.getUsername());
		return customerRepo.save(c);
	}

	@Override
	public Customer delete(int id) {
		Customer customer = customerRepo.getOne(id);
		if (customer == null) {
			return new Customer();
		}
		customerRepo.deleteById(id);
		return customer;
	}

	@Override
	public Customer validateCustomer(Customer customer) {
		Customer c = customerRepo.getCustomerByUsername(customer.getUsername());
		if (c == null) {
			return new Customer();
		}
		if (c.getUsername().equals(customer.getUsername()) && c.getPassword().equals(customer.getPassword())) {
			return c;
		}
		return new Customer();
	}

}
