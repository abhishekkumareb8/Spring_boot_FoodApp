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

import com.ty.foodboot.springboot_foodapp.dto.Items;
import com.ty.foodboot.springboot_foodapp.service.ItemsService;
import com.ty.foodboot.springboot_foodapp.util.ResponseStructure;

@RestController
@RequestMapping("items")
public class ItemsController {
	
	@Autowired
	private ItemsService service; 

	@PostMapping
	public ResponseStructure<Items> saveItems(@RequestBody Items items) {
		return service.saveItems(items);
	}
	
	@GetMapping
	public ResponseStructure<Items> getItemsById(@RequestParam int id){
		return service.getItemsById(id);
	}
	
	@PutMapping
	public ResponseStructure<Items> updateItemsById(@RequestBody Items items, @RequestParam int id){
		return service.updateItems(items, id);
	}
	
	@DeleteMapping
	public ResponseStructure<String> deleteItemsById(@RequestParam int id){
		return service.deleteItems(id);
	}
}
