package com.CoffeeShop.Coffeeshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.CoffeShop.Coffeeshop.model.Address;
import com.CoffeShop.Coffeeshop.model.Product;

@Service
public interface AddressService {
	public Address AddAddress(Address address); 
	public List<Address> getAddress();
	public Address getById(int productId);
	public Address getByemail_id(String email);
	public ResponseEntity<?> updateAddress(Address address);
	public Address getByAddressId(int id);
}
