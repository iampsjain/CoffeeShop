package com.CoffeeShop.Coffeeshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CoffeShop.Coffeeshop.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

	@Query("Select a from Address a where a.ProductId=?1")
	public Address getAddressByproductId(int productId);
	
	@Query("Select a from Address a where a.email_id=?1")
	public Address getAddressByEmailId(String emailId);

	

}
