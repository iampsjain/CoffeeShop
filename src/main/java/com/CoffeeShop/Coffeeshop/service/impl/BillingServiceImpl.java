<<<<<<< HEAD
package com.CoffeeShop.Coffeeshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CoffeShop.Coffeeshop.model.Address;
import com.CoffeShop.Coffeeshop.model.Billing;
import com.CoffeeShop.Coffeeshop.repo.AddressRepo;
import com.CoffeeShop.Coffeeshop.repo.BillingRepo;
import com.CoffeeShop.Coffeeshop.service.BillingService;

@Service
public class BillingServiceImpl implements BillingService {
	@Autowired
	BillingRepo billingRepo;

	@Autowired
	AddressRepo addressRepo;

	@Override
	public List<Billing> getBillings(int customer_id) {
		// TODO Auto-generated method stub
		return billingRepo.findAll();
	}

	@Override
	public Address getBiilingAddress(int billingId) {
		Billing bill = billingRepo.getOne(billingId);
		Address address = addressRepo.getOne(bill.getAddressId());
		return address;
	}

	@Override
	public Billing addBill(Billing billing) {
		return billingRepo.save(billing);
	}

	@Override
	public Billing updateBill(Billing billing) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Billing> getAllbill() {
		// TODO Auto-generated method stub
		return billingRepo.findAll();
	}

}
=======
package com.CoffeeShop.Coffeeshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CoffeShop.Coffeeshop.model.Address;
import com.CoffeShop.Coffeeshop.model.Billing;
import com.CoffeShop.Coffeeshop.model.Customer;
import com.CoffeeShop.Coffeeshop.repo.AddressRepo;
import com.CoffeeShop.Coffeeshop.repo.BillingRepo;
import com.CoffeeShop.Coffeeshop.service.BillingService;

@Service
public class BillingServiceImpl implements BillingService {
	@Autowired
	BillingRepo billingRepo;

	@Autowired
	AddressRepo addressRepo;

	@Override
	public List<Billing> getBillings(int customer_id) {
		// TODO Auto-generated method stub
		return billingRepo.findAll();
	}

	@Override
	public Address getBiilingAddress(int billingId) {
		Billing bill = billingRepo.getOne(billingId);
		Address address = addressRepo.getOne(bill.getAddressId());
		return address;
	}

	@Override
	public Billing addBill(Billing billing) {
		return billingRepo.save(billing);
	}

	@Override
	public Billing updateBill(Billing billing) {
		// TODO Auto-generated method stu
		
		return null;
	}

	@Override
	public Billing getBillByCustomerId(int id) {
		 
		return billingRepo.getBillByCustomerId(id);
	}

}
>>>>>>> 451ddff2d9d1d00bb2aa5f6d9578238f2dd6bbba
