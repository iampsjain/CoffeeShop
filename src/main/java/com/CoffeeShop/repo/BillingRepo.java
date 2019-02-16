package com.CoffeeShop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CoffeShop.model.Billing;

@Repository
public interface BillingRepo  extends JpaRepository<Billing, Integer>  {

}
