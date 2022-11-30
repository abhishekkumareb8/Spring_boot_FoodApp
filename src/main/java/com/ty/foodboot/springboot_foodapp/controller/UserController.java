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

import com.ty.foodboot.springboot_foodapp.dto.User;
import com.ty.foodboot.springboot_foodapp.service.UserService;
import com.ty.foodboot.springboot_foodapp.util.ResponseStructure;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseStructure<User> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@GetMapping
	public ResponseStructure<User> getUserById(@RequestParam int id){
		return service.getUserById(id);
	}
	
	@PutMapping
	public ResponseStructure<User> updateUserById(@RequestBody User user , @RequestParam int id){
		return service.updateUser1(user, id);
	}
	
	@DeleteMapping
	public ResponseStructure<String> deleteUserById(@RequestParam int id){
		return service.deleteUser(id);
	}

}
