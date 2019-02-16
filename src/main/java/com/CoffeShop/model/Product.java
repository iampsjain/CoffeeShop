package com.CoffeShop.model;

import javax.persistence.*;

@Entity
@Table
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int id;
	
	
	
	
	
}
