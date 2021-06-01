package com.cganna.springweb.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cganna.springweb.entities.Product;
import com.cganna.springweb.repos.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductRepository productRepo;
	
	private static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@GetMapping()
	public List<Product> getAllProducts() {
		LOGGER.debug("Listing all the products available");
		return productRepo.findAll();
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable int id) {
		LOGGER.debug("Getting Product Information with Id {}",id);
		return productRepo.findById(id).get();
	}
	
	@PostMapping()
	public Product createProduct(@RequestBody Product product) {
		
		return productRepo.save(product);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@RequestBody Product product,@PathVariable int id) {
		
		return productRepo.save(product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable int id) {
			productRepo.deleteById(id);
	}
}
