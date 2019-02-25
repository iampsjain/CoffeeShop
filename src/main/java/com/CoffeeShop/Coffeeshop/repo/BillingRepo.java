package com.CoffeeShop.Coffeeshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CoffeShop.Coffeeshop.model.Billing;
 
@Repository

public interface BillingRepo  extends JpaRepository<Billing, Integer>  {

	@Query(value="SELECT b FROM Billing b WHERE b.customer_id=:cid")
	public Billing getBillByCustomerId(@Param("cid") int id);
	
}
