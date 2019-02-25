package com.CoffeeShop.Coffeeshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CoffeShop.Coffeeshop.model.Address;
import com.CoffeShop.Coffeeshop.model.Billing;
import com.CoffeShop.Coffeeshop.model.Product;
import com.CoffeeShop.Coffeeshop.repo.AddressRepo;
import com.CoffeeShop.Coffeeshop.repo.BillingRepo;
import com.CoffeeShop.Coffeeshop.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	AddressRepo addressRepo;
	
	

	@Override
	public Address AddAddress(Address address) {
		
		return addressRepo.save(address);
	}



	@Override
	public List<Address> getAddress() {
		// TODO Auto-generated method stub
		return addressRepo.findAll();
	}



	@Override
	public Address getById(int productId) {
		// TODO Auto-generated method stub
		return addressRepo.getAddressByproductId(productId);
	}



	@Override
	public Address updateAddress(Address address) {
		Address p = addressRepo.getOne(address.getId());
		p.setProductId(address.getProductId());
		 
		return addressRepo.save(p);
	}



	@Override
	public Address getByemail_id(String email) {
		Address p = addressRepo.getAddressByEmailId(email);
		
		return p;
	}



	@Override
	public Address getByAddressId(int id) {
		
		return addressRepo.getOne(id);
	}
}
