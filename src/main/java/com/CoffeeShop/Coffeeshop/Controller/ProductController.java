package com.CoffeeShop.Coffeeshop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.CoffeShop.Coffeeshop.model.Product;
import com.CoffeeShop.Coffeeshop.service.ProductService;

import javassist.NotFoundException;

@RestController

public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping("/product")
	public List<Product> getAll() {
		return productService.getAll();
	}

	@GetMapping("/product/{product_id}")
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

	
	@DeleteMapping("/product/{product_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable int product_id) throws NotFoundException {
		 try {
			 productService.deleteById(product_id); // or just use the repository directly
		    } catch (EmptyResultDataAccessException ex) {
		        // either do nothing to return a 204, or
		        throw new NotFoundException(null, ex);
		    }
		 
	}
}
