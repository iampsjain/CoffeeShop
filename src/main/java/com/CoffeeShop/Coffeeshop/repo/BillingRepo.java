package com.CoffeeShop.Coffeeshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CoffeShop.Coffeeshop.model.Billing;

@Repository
public interface BillingRepo  extends JpaRepository<Billing, Integer>  {

}
