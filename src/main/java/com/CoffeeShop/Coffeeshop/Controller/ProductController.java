package com.CoffeeShop.Coffeeshop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CoffeShop.Coffeeshop.model.Product;
import com.CoffeeShop.Coffeeshop.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping("/product")
	public List<Product> getAll() {
		return productService.getAll();
	}

	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable int product_id) {
		return productService.getProduct(product_id);
	}

	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@DeleteMapping("/product")
	public Product deleteProduct(@RequestBody int product_id) {
		return productService.deleteProduct(product_id);
	}
}
