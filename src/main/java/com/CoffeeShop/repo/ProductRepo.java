package com.CoffeeShop.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CoffeShop.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
