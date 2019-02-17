package com.CoffeeShop.Coffeeshop.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.CoffeShop.Coffeeshop.model.Product;

public interface customerpagniationrepo extends PagingAndSortingRepository<Product, Long> {

}
