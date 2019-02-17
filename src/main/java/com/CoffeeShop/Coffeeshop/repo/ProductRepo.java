package com.CoffeeShop.Coffeeshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CoffeShop.Coffeeshop.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	Product getProductById(int id);
	void deleteById(int id);
}
