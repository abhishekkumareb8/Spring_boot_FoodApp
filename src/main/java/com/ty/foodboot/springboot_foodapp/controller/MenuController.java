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

import com.ty.foodboot.springboot_foodapp.dto.Menu;
import com.ty.foodboot.springboot_foodapp.service.MenuService;
import com.ty.foodboot.springboot_foodapp.util.ResponseStructure;

@RestController
@RequestMapping("menu")
public class MenuController {
	
	@Autowired
	private MenuService service ;

	@PostMapping
	public ResponseStructure<Menu> saveUser(@RequestBody Menu menu) {
		return service.saveMenu(menu);
	}
	
	@GetMapping
	public ResponseStructure<Menu> getUserById(@RequestParam int id){
		return service.getMenuById(id);
	}
	
	@PutMapping
	public ResponseStructure<Menu> updateUserById(@RequestBody Menu menu, @RequestParam int id){
		return service.updateMenu(menu, id);
	}
	
	@DeleteMapping
	public ResponseStructure<String> deleteUserById(@RequestParam int id){
		return service.deleteMenu(id);
	}
}
