package com.CoffeeShop.Coffeeshop.service.impl;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> updateAddress(Address address) {
		Address p = null;
		HttpServletResponse response;
		try {
		 p= addressRepo.getOne(address.getId());
		
		
		p.setProductId(address.getProductId());
		p.setAddress(address.getAddress());
		p.setCity(address.getCity());
		p.setEmail_id(address.getEmail_id());
		p.setMobile_number(address.getMobile_number());
		p.setName(address.getName());
		p.setPincode(address.getPincode());
		p.setSurname(address.getSurname());
		p.setState(address.getState());
		addressRepo.save(p);
		
		}
		catch(Exception e) {
			
			return new ResponseEntity<>("Id Not Found", HttpStatus.NOT_FOUND);
		}
	return new ResponseEntity<>("Data Updated With id =  "+p.getId(), HttpStatus.OK);
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
