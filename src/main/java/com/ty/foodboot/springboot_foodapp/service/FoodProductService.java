package com.ty.foodboot.springboot_foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodboot.springboot_foodapp.dao.FoodOrderDao;
import com.ty.foodboot.springboot_foodapp.dto.FoodOrder;
import com.ty.foodboot.springboot_foodapp.dto.Product;
import com.ty.foodboot.springboot_foodapp.dto.User;
import com.ty.foodboot.springboot_foodapp.exception.NoSuchElementFoundException;
import com.ty.foodboot.springboot_foodapp.exception.UnableToUpdateException;
import com.ty.foodboot.springboot_foodapp.util.ResponseStructure;

@Service
public class FoodProductService {
	
	@Autowired
	private FoodOrderDao dao ;
	
	public ResponseStructure<FoodOrder> saveFoodOrder(FoodOrder foodOrder ) {
		List<Product> list=foodOrder.getList();
		double totelCost=0;
		for(Product product:list) {
			totelCost=totelCost+(product.getPrice()*product.getQuantity());
		}
		totelCost=(totelCost*0.18)+totelCost;
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveFoodOrder(foodOrder));
		return responseStructure;
	}

	public ResponseStructure<String> deleteFoodOrder(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteFoodOrderById(id));
		return responseStructure;
	}

	public ResponseStructure<FoodOrder> updateFoodOrder(FoodOrder foodOrder, int id) {
		FoodOrder foodOrder2= dao.getFoodOrderById(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		if (foodOrder2 != null) {
			foodOrder.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(dao.updateFoodOrder(foodOrder));

		} 
		else {
			throw new UnableToUpdateException("No Id Found To Update");
		}
		return responseStructure;
	}

	public ResponseStructure<FoodOrder> getFoodOrderById(int id) {
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		FoodOrder foodOrder2 = dao.getFoodOrderById(id);
		if (foodOrder2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Received");
			responseStructure.setData(dao.getFoodOrderById(id));
		} else {
			throw new NoSuchElementFoundException("No Id Found In Data Base For User");
		}
		return responseStructure;
	}

}
