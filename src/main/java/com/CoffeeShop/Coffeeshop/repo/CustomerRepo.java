package com.CoffeeShop.Coffeeshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CoffeShop.Coffeeshop.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	public Customer getCustomerByUsername(String username);
	public Customer getCustomerById(int id);
}
