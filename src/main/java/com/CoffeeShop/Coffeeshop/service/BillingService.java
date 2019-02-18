package com.CoffeeShop.Coffeeshop.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.CoffeShop.Coffeeshop.model.Address;
import com.CoffeShop.Coffeeshop.model.Billing;
 
@Service
public interface BillingService {
	public List<Billing> getBillings(int customer_id);

	public Address getBiilingAddress(int billingId);

	public Billing addBill(Billing billing);

	public Billing updateBill(Billing billing);
	
	public Billing getBillByCustomerId(int id);
	
	 


}
