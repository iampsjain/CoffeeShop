package com.CoffeeShop.Coffeeshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CoffeShop.Coffeeshop.model.Product;

@Service
public interface ProductService {
	public List<Product> getAll();

	public Product getProduct(int product_id);
	
	public Product addProduct(Product product);
	
	public Product updateProduct(Product product);
	
	public Product deleteProduct(int product_id);
	
}
