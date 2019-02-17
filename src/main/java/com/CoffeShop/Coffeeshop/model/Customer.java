package com.CoffeShop.Coffeeshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	int id;	

	@Column
	String name;
	
	@Column
	String Bill;
	
	@Column
	String surname;
	
	@Column
	String Role;
	
	@Column
	String addressID;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getBill() {
		return Bill;
	}

	public void setBill(String bill) {
		Bill = bill;
	}

	public String getAddressID() {
		return addressID;
	}

	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

}
