package com.CoffeeShop.Coffeeshop.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.CoffeShop.Coffeeshop.model.Product;
import com.CoffeeShop.Coffeeshop.repo.ProductRepo;
import com.CoffeeShop.Coffeeshop.service.ProductService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;

	@Override
	public List<Product> getAll() {
		return productRepo.findAll();
	}

	@Override
	public Product getProduct(int product_id) {
		int id = product_id;
		return productRepo.getProductById(id);
	}

	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Product p = productRepo.getOne(product.getId());
		if (p == null) {
			return new Product();
		}
		p.setDescription(product.getDescription());
		p.setImgurl(product.getImgurl());
		p.setPrice(product.getPrice());
		p.setTitle(product.getTitle());
		return productRepo.save(p);
	}

	@Override
	public void deleteById(int product_id) {
		
		productRepo.deleteById(product_id);

	}
}
