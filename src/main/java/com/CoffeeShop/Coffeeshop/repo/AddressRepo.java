package com.CoffeeShop.Coffeeshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CoffeShop.Coffeeshop.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

}
