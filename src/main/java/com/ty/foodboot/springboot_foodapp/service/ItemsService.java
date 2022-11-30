package com.ty.foodboot.springboot_foodapp.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodboot.springboot_foodapp.dao.ItemsDao;
import com.ty.foodboot.springboot_foodapp.dto.Items;
import com.ty.foodboot.springboot_foodapp.dto.User;
import com.ty.foodboot.springboot_foodapp.exception.UnableToUpdateException;
import com.ty.foodboot.springboot_foodapp.util.ResponseStructure;

@Service
public class ItemsService {
	
	@Autowired
	private ItemsDao dao;

	public ResponseStructure<Items> saveItems(Items items) {
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveItems(items));
		return responseStructure;
	}

	public ResponseStructure<String> deleteItems(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteItemsById(id));
		return responseStructure;
	}

	public ResponseStructure<Items> updateItems(Items items, int id) {
		Items items2 = dao.getItemsById(id);
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		if(items2!=null) {
			items.setId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.updateItems(items));
		
		}else
		{
			throw new UnableToUpdateException();
		}
		return responseStructure;
	}
	public ResponseStructure<Items> getItemsById(int id){
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		Items items2=dao.getItemsById(id);
		if(items2!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(dao.getItemsById(id));
		return responseStructure;
		}
		else {
			throw new NoSuchElementException();
		}
	}
}
