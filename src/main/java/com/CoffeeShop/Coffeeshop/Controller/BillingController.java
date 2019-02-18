package com.CoffeeShop.Coffeeshop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CoffeShop.Coffeeshop.model.Address;
import com.CoffeShop.Coffeeshop.model.Billing;
import com.CoffeShop.Coffeeshop.model.Customer;
import com.CoffeeShop.Coffeeshop.service.BillingService;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@RestController
public class BillingController {
	@Autowired
	BillingService billingService;

	@GetMapping("/billing/{customer_id}")
	public List<Billing> getBillings(@PathVariable int customer_id) {
		return billingService.getBillings(customer_id);
	}

	@GetMapping("/address/{billingId}")
	public Address getBiilingAddress(int billingId) {
		return billingService.getBiilingAddress(billingId);
	}

	@PostMapping("/billing")
	public Billing addBill(@RequestBody Billing billing) {
		return billingService.addBill(billing);
	}
 
	@GetMapping("/testbill/{id}")
	public Billing getBillByCustomerId(@PathVariable("id") int id)
	{
		return billingService.getBillByCustomerId(id);
	}

}
