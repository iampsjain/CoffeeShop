package com.CoffeeShop.Coffeeshop.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CoffeShop.Coffeeshop.model.Address;
import com.CoffeeShop.Coffeeshop.service.AddressService;
import com.CoffeeShop.Coffeeshop.service.BillingService;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;
	@PostMapping("/address")
	public Address addAddress(@RequestBody() Address address) {
		return addressService.AddAddress(address);
	}
	@GetMapping("/address")
	public List<Address> getAddress() {
		return addressService.getAddress();
	}
	@GetMapping("/address/getbyid/{productId}")
	public Address getById(@PathVariable("productId") int productId) {
		return addressService.getById(productId);
	}
	@PutMapping("/address") 
	public ResponseEntity<?> putAddress(@RequestBody Address address) {
		return addressService.updateAddress(address);
	}
}
