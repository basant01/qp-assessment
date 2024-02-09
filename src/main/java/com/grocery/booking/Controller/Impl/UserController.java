package com.grocery.booking.Controller.Impl;


import com.grocery.booking.Model.GroceryItem;
import com.grocery.booking.Model.OrderItem;
import com.grocery.booking.Model.UserOrder;
import com.grocery.booking.Service.GroceryService;
import com.grocery.booking.Service.UserOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

	@Autowired
	private  GroceryService groceryService;

	@Autowired
	private UserOrderService userOrderService;

	@GetMapping("/grocery-items")
	public List<GroceryItem> getAllGroceryItems() {
		return groceryService.getAllItems();
	}

	@PostMapping("/create-order")
	public ResponseEntity<UserOrder> createOrder(@RequestBody UserOrder userOrder) {
		UserOrder createdOrder = userOrderService.createOrder(userOrder);
		return ResponseEntity.ok(createdOrder);
	}

}
