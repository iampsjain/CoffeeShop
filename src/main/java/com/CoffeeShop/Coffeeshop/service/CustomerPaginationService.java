package com.CoffeeShop.Coffeeshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import com.CoffeShop.Coffeeshop.model.Product;
import com.CoffeeShop.Coffeeshop.repo.customerpagniationrepo;

@Service
public class CustomerPaginationService {

	private final static int PAGESIZE = 3;
	
	@Autowired
	customerpagniationrepo repository;
	
	public void save(Product customer) {
		repository.save(customer);
	}
	
	public Iterable<Product> findAllCustomers() {
		return repository.findAll();
	}
	
	public List<Product> getPage(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber, PAGESIZE, Sort.Direction.ASC, "id");
		
		return repository.findAll(request).getContent();
	}
}
