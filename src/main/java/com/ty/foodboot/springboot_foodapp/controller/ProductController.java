package com.ty.foodboot.springboot_foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodboot.springboot_foodapp.dto.Product;
import com.ty.foodboot.springboot_foodapp.dto.User;
import com.ty.foodboot.springboot_foodapp.service.ProductService;
import com.ty.foodboot.springboot_foodapp.util.ResponseStructure;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductService service;

	@PostMapping
	public ResponseStructure<Product> saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@GetMapping
	public ResponseStructure<Product> getProductById(@RequestParam int id){
		return service.getProductById(id);
	}
	
	@PutMapping
	public ResponseStructure<Product> updateProductById(@RequestBody Product product , @RequestParam int id){
		return service.updateProduct(product, id);
	}
	
	@DeleteMapping
	public ResponseStructure<String> deleteProductById(@RequestParam int id){
		return service.deleteProduct(id);
	}
}
