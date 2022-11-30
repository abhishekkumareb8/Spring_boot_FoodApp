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

import com.ty.foodboot.springboot_foodapp.dto.FoodOrder;
import com.ty.foodboot.springboot_foodapp.service.FoodProductService;
import com.ty.foodboot.springboot_foodapp.util.ResponseStructure;

@RestController
@RequestMapping("foodorder")
public class FoodOrderController {

	@Autowired
	private FoodProductService service; 
	
	@PostMapping
	public ResponseStructure<FoodOrder> saveUser(@RequestBody FoodOrder foodOrder) {
		return service.saveFoodOrder(foodOrder);
	}
	
	@GetMapping
	public ResponseStructure<FoodOrder> getUserById(@RequestParam int id){
		return service.getFoodOrderById(id);
	}
	
	@PutMapping
	public ResponseStructure<FoodOrder> updateUserById(@RequestBody FoodOrder foodOrder , @RequestParam int id){
		return service.updateFoodOrder(foodOrder, id);
	}
	
	@DeleteMapping
	public ResponseStructure<String> deleteUserById(@RequestParam int id){
		return service.deleteFoodOrder(id);
	}
}
